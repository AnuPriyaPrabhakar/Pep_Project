package com.ponsun.pep.algorithm;


import com.ponsun.pep.Search.data.RecordDTO;
import com.ponsun.pep.Search.data.SearchDTO;
import com.ponsun.pep.algorithm.ExactMatch.ExactMatch;
import com.ponsun.pep.algorithm.Jaro.Jarowinkler_Match;
import com.ponsun.pep.algorithm.cdo.CriminalRuleCDO;
import com.ponsun.pep.customerDetails.data.CustomerDetailsData;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchDetails.service.SearchDetailsWritePlatformService;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.services.HitRecordWritePlatformService;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.services.SearchResultWritePlatformService;
import info.debatty.java.stringsimilarity.JaroWinkler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.apache.commons.math3.util.Precision.round;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScoringCalculator {

    private final KieContainer kieContainer;
    private final SearchResultWritePlatformService searchResultWritePlatformService;
    private final JdbcTemplate jdbcTemplate;
    private final SearchDetailsWritePlatformService searchDetailsWritePlatformService;
    private final HitRecordWritePlatformService hitRecordWritePlatformService;
    JaroWinkler jw = new JaroWinkler();

    @Transactional
    public List<RecordDTO> calculateScore(SearchDTO searchDTO, List<CustomerDetailsData> customerDetailsData) {
        List<RecordDTO> recordDTOS = new ArrayList<>();
        List<RecordDTO> listOfArrays = new ArrayList<>();
        String queryCustomer = searchDTO.getName();
        Double matching_score = searchDTO.getMatching_score();
        Integer uid = searchDTO.getUid();

        ModelMapper modelMapper = new ModelMapper();
        CreateSearchResultRequest request = modelMapper.map(searchDTO, CreateSearchResultRequest.class);
        Response response = this.searchResultWritePlatformService.createSearch(request);
        Integer searchId = (Integer) response.getId();

        for (CustomerDetailsData customerDetails : customerDetailsData) {
            //String str2 = customerDetails.getName();
            String str2 = customerDetails.getName();//name
            str2 = str2.replaceAll(",", " ");
            str2 = str2.replaceAll("[^a-zA-Z0-9\\s]", "");
            double value1 = 0;
            double value2 = 0;
            double value3 = 0;

//            try {
//                value1 = round(Oneside.onesideMatching(queryCustomer, str2), 0);
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("onside:" + queryCustomer + " " + str2 + "  " + e);
//            }
            try {
                value2 = round(ExactMatch.ExactMatching(queryCustomer, str2), 0);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("exactMatch:" + queryCustomer + " " + str2 + "  " + e);
            }
            try {
                value3 = round(Jarowinkler_Match.getJarowinklerMatching(queryCustomer, str2), 0);
                if (Double.isNaN(value3)) {
                    value3 = 0;
                    //System.out.println("problem : "+str2);
                    // Handle or log the NaN value, maybe throw an exception
                    //throw new IllegalArgumentException("Invalid numeric value: NaN");
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Jarowinkler_Match:" + queryCustomer + " " + str2 + "  " + e);
            }
            boolean isCriminalScoreVerified = isCriminalRulePassed(value1, value2, value3, matching_score);
            if (isCriminalScoreVerified) {
                RecordDTO recordDTO = new RecordDTO();
                recordDTO.setId(customerDetails.getId());
                recordDTO.setName(customerDetails.getName());
                recordDTO.setDob(customerDetails.getDob());
                recordDTO.setPlaceOfBirth(customerDetails.getPlaceOfBirth());
                recordDTO.setPan(customerDetails.getPan());
                recordDTO.setDirectorsIdentificationNumber(customerDetails.getDirectorsIdentificationNumber());
                recordDTO.setScore(Math.max(Math.max(value1, value2), value3));
//                recordDTOS.add(recordDTO);
                listOfArrays.add(recordDTO);
            }
        }

        Collections.sort(listOfArrays, Comparator.comparingDouble(RecordDTO::getScore));
        Map<Integer, RecordDTO> map = new HashMap<>();
        for (RecordDTO array : listOfArrays) {
            int uniqueValue = array.getId();
            map.put(uniqueValue, array);
        }

        List<RecordDTO> uniqueListOfArrays = new ArrayList<>(map.values());
        for (RecordDTO array : uniqueListOfArrays) {
            RecordDTO recordDTO = new RecordDTO();
            CreateHitRecordRequest request1 = new CreateHitRecordRequest();

            request1.setName(array.getName());
            request1.setSearchId(searchId);
            request1.setCriminalId(array.getId());
            request1.setDisplay("P" + array.getId());
            request1.setMatchingScore(array.getScore());
            request1.setCycleId(1);
            request1.setStatusNowId(0);

            Response hitResponse = hitRecordWritePlatformService.createHitRecord(request1);
            Integer hitRecId = (Integer) hitResponse.getId();

            recordDTO.setId(array.getId());
            recordDTO.setName(array.getName());
            recordDTO.setDob(array.getDob());
            recordDTO.setPlaceOfBirth(array.getPlaceOfBirth());
            recordDTO.setPan(array.getPan());
            recordDTO.setDirectorsIdentificationNumber(array.getDirectorsIdentificationNumber());
            recordDTO.setSearchId(searchId);
            recordDTO.setHitId(hitRecId);
            //System.out.println("hitRecId:" + hitRecId);
            recordDTO.setScore(array.getScore());
            recordDTOS.add(recordDTO);
        }

        Collections.sort(recordDTOS, Comparator.comparingDouble(RecordDTO::getScore).reversed());
        return recordDTOS;
    }

    private boolean isCriminalRulePassed(final String value1, final String value2, final double jaroWinkler, final double matching_score) {
        if (StringUtils.isBlank(value1)) {
            //throw error;
        }
        if (StringUtils.isBlank(value2)) {
            //throw error;
        }
        double value1d = Double.parseDouble(value1);
        double value2d = Double.parseDouble(value2);
        return isCriminalRulePassed(value1d, value2d, jaroWinkler, matching_score);
    }

    private boolean isCriminalRulePassed(final double value1, final double value2, final double jaroWinkler, final double matching_score) {
        final KieSession ruleSession = kieContainer.newKieSession();
        try {
            final CriminalRuleCDO criminalRuleCDO = new CriminalRuleCDO();
            criminalRuleCDO.setScore1(value1);
            criminalRuleCDO.setScore2(value2);
            criminalRuleCDO.setScore3(jaroWinkler);
            criminalRuleCDO.setSearchscore(matching_score);
            ruleSession.insert(criminalRuleCDO);
            ruleSession.fireAllRules();

            if (StringUtils.isNoneBlank(criminalRuleCDO.getStatus())
                    && criminalRuleCDO.getStatus().equalsIgnoreCase("success")) {
                return true;
            }
            return false;
        } finally {
            ruleSession.dispose();
        }
    }
}

