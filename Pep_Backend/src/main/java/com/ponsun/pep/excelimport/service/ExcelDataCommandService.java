package com.ponsun.pep.excelimport.service;

import com.ponsun.pep.EhcachePOC.Data.OFACData;
import com.ponsun.pep.EhcachePOC.Service.OFACSearchService;
import com.ponsun.pep.Search.services.SearchWritePlatformService;
import com.ponsun.pep.algorithm.ScoringCalculator;
import com.ponsun.pep.dto.ScreenDTO;
import com.ponsun.pep.dto.SearchDTO;
import com.ponsun.pep.excelimport.dto.ExcelDataDto;
import com.ponsun.pep.excelimport.entity.ExcelData;
import com.ponsun.pep.excelimport.repository.ExcelDataRepository;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.pep.searchDetails.service.SearchDetailsWritePlatformService;
import com.ponsun.pep.searchLifcycle.searchResult.services.SearchResultWritePlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExcelDataCommandService {

    private final ExcelDataRepository excelDataRepository;
    private final OFACSearchService ofacsearchService;
    private final ScoringCalculator scoringCalculator;
    private final ExcelReadService excelReadService;
    private final SearchDetailsWritePlatformService searchDetailsWritePlatformService;
    private final SearchWritePlatformService searchWritePlatformService;
    private final SearchResultWritePlatformService searchResultWritePlatformService;

    public ExcelData save(ExcelDataDto input) {
        ExcelData excelData = new ExcelData();
        excelData.setName(input.getName());
        excelData.setType(input.getType());
        excelData.setScore(input.getScore());
        excelData.setCountry(input.getCountry());
        return excelDataRepository.save(excelData);
    }
    @Transactional
    public Response saveBulkData(List<Map<String, Object>> rows) {
        try {
            long totalRecordSaved = 0L;
            long startTime = System.currentTimeMillis();

            List<SearchDTO> searchDTOList = new ArrayList<>();

            for (Map<String, Object> row : rows) {
                final String name = ((String) row.get("name")).trim();
                String score = ((String) row.get("score"));
                final String type = ((String) row.get("type")).trim();
                final String country = ((String) row.get("country")).trim();
                SearchDTO searchDTO = new SearchDTO();
                searchDTO.setName(name);
                searchDTO.setMatching_score(Double.parseDouble(score));
                searchDTOList.add(searchDTO);
                totalRecordSaved = totalRecordSaved + 1;
            }

            for (SearchDTO searchDTO : searchDTOList) {
                CreateSearchDetailsRequest createSearchDetailsRequest = new CreateSearchDetailsRequest();
                createSearchDetailsRequest.setName(searchDTO.getName());
                createSearchDetailsRequest.setMatchingScore(searchDTO.getMatching_score());
                searchDetailsWritePlatformService.createSearchDetails(createSearchDetailsRequest);
            }

            List<OFACData> ofacdataList = this.ofacsearchService.fetchAllOFACData();
            this.excelReadService.calculateScore(searchDTOList,ofacdataList);

            long endTime = System.currentTimeMillis();
            System.out.println("Total milli seconds taken " + (endTime - startTime));
            return new Response(totalRecordSaved);
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saveBulkData {}", e.getMessage());
            throw new EQAS_PEP_AppicationException(e.getMessage());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Response saveKycScreeningData(List<ScreenDTO> screenDTOList) {
        try {
            long totalRecordSaved = 0L;
            long startTime = System.currentTimeMillis();
            List<OFACData> ofacdataList = this.ofacsearchService.fetchAllOFACData();

            // Filter out duplicates in screenDTOList based on name
            Set<String> uniqueNames = new HashSet<>();
            List<ScreenDTO> filteredList = screenDTOList.stream()
                    .filter(screenDTO -> uniqueNames.add(screenDTO.getName()))
                    .collect(Collectors.toList());

            for (ScreenDTO screenDTO : filteredList) {
                CreateSearchDetailsRequest createSearchDetailsRequest = new CreateSearchDetailsRequest();
                createSearchDetailsRequest.setName(screenDTO.getName());
                createSearchDetailsRequest.setMatchingScore(screenDTO.getSearchingScore());
                createSearchDetailsRequest.setKycId(screenDTO.getKycId());
                createSearchDetailsRequest.setUid(screenDTO.getUid());
                createSearchDetailsRequest.setApplicantId(screenDTO.getApplicantFormId());
                searchDetailsWritePlatformService.createSearchDetails(createSearchDetailsRequest);

            }

            this.excelReadService.calculateScores(filteredList, ofacdataList);

            long endTime = System.currentTimeMillis();
            System.out.println("Total milliseconds taken " + (endTime - startTime));
            return new Response(totalRecordSaved);
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving data {}", e.getMessage());
            throw new EQAS_PEP_AppicationException(e.getMessage());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    ///////////////////////////////
//
}



//@Transactional
//    public Response saveKycScreeningData(List<ScreenDTO> screenDTOList) {
//        try {
//            long totalRecordSaved = 0L;
//            long startTime = System.currentTimeMillis();
//            List<OFACData> ofacdataList = this.ofacsearchService.fetchAllOFACData();
//
//            for (ScreenDTO screenDTO : screenDTOList) {
//                CreateSearchDetailsRequest createSearchDetailsRequest = new CreateSearchDetailsRequest();
//                createSearchDetailsRequest.setName(screenDTO.getName());
//                createSearchDetailsRequest.setMatchingScore(screenDTO.getSearchingScore());
//                createSearchDetailsRequest.setKycId(screenDTO.getKycId());
//                createSearchDetailsRequest.setUid(screenDTO.getUid());
//                searchDetailsWritePlatformService.createSearchDetails(createSearchDetailsRequest);
//
//            this.excelReadService.calculateScores(screenDTOList,ofacdataList);
//            }
//            long endTime = System.currentTimeMillis();
//            System.out.println("Total milli seconds taken " + (endTime - startTime));
//            return new Response(totalRecordSaved);
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saveBulkData {}", e.getMessage());
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
///////////////////////////////