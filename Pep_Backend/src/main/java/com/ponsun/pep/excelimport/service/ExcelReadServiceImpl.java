package com.ponsun.pep.excelimport.service;

import com.ponsun.pep.EhcachePOC.Data.OFACData;
import com.ponsun.pep.algorithm.ScoringCalculatorService;
import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.dto.ScreenDTO;
import com.ponsun.pep.dto.SearchDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.HitRecord.services.HitRecordWritePlatformService;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.services.SearchResultWritePlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExcelReadServiceImpl implements ExcelReadService {

    private final SearchResultWritePlatformService searchResultWritePlatformService;
    private final ScoringCalculatorService scoringCalculatorService;
    private final HitRecordWritePlatformService hitRecordWritePlatformService;
    @Override
    @Transactional
    public void calculateScore(List<SearchDTO> searchDTOList,List<OFACData> ofacdataList) throws ExecutionException, InterruptedException {
        List<RecordDTO> listOfArrays = new ArrayList<>();

        for (SearchDTO searchDTO : searchDTOList) {
            String name = searchDTO.getName();
            Double matchingScore = searchDTO.getMatching_score();
            Integer applicanFormId = 0;
            Integer uid          = 0;

            ModelMapper modelMapper = new ModelMapper();
            CreateSearchResultRequest request = modelMapper.map(searchDTO, CreateSearchResultRequest.class);
            Response response = this.searchResultWritePlatformService.createSearch(request);
            Integer searchId = (Integer) response.getId();

            listOfArrays = this.scoringCalculatorService.calculatenamewiseScore(name, matchingScore, searchId, ofacdataList).get();

            Collections.sort(listOfArrays, Comparator.comparingDouble(RecordDTO::getScore));

            Map<Integer, RecordDTO> map = new HashMap<>();
            for (RecordDTO array : listOfArrays) {
                int uniqueValue = array.getIds();
                map.put(uniqueValue, array);
            }
            List<RecordDTO> uniqueListOfArrays = new ArrayList<>(map.values());
            this.hitRecordWritePlatformService.createlistodHitData(uniqueListOfArrays,uid);
        }
    }

    @Override
    @Transactional
    public void calculateScores(List<ScreenDTO> screenDTOList, List<OFACData> ofacdataList) throws ExecutionException, InterruptedException {
        List<RecordDTO> listOfArrays = new ArrayList<>();

        for (ScreenDTO screenDTO : screenDTOList) {
            String name = screenDTO.getName();
            Double matchingScore = screenDTO.getSearchingScore();
            Integer uid = screenDTO.getUid();

            ModelMapper modelMapper = new ModelMapper();
            CreateSearchResultRequest request = modelMapper.map(screenDTO, CreateSearchResultRequest.class);
            Response response = this.searchResultWritePlatformService.createSearch(request);
            Integer searchId = (Integer) response.getId();

            listOfArrays = this.scoringCalculatorService.calculatenamewiseScore(name, matchingScore, searchId, ofacdataList).get();

            Collections.sort(listOfArrays, Comparator.comparingDouble(RecordDTO::getScore));

            Map<Integer, RecordDTO> map = new HashMap<>();
            for (RecordDTO array : listOfArrays) {
                int uniqueValue = array.getIds();
                map.put(uniqueValue, array);
            }
//
            List<RecordDTO> uniqueListOfArrays = new ArrayList<>(map.values());
            this.hitRecordWritePlatformService.createlistodHitData(uniqueListOfArrays,uid);
        }
//        return uniqueListOfArrays;
    }
}
