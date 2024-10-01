package com.ponsun.pep.algorithm;

import com.ponsun.pep.EhcachePOC.Data.OFACData;
import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.nameSearch.Count.service.RecordDetails;
import com.ponsun.pep.nameSearch.Count.service.RecordReadService;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.services.HitRecordWritePlatformService;
import com.ponsun.pep.uiTest.AlgorithmTesting.ExactMatch.ExactMatch;
import com.ponsun.pep.uiTest.AlgorithmTesting.Fuzzy.Fuzzy_WeightedRatio;
import com.ponsun.pep.uiTest.AlgorithmTesting.Jaro.Jarowinkler_Match;
import com.ponsun.pep.uiTest.AlgorithmTesting.Oneside.Oneside;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScoringCalculatorService {
    private final PepRecordDetails recordDetails;
    private final AlgorithmRule algorithmRule;
    private final HitRecordWritePlatformService hitRecordWritePlatformService;
    private final RecordReadService recordReadService;
    private final RecordDetails recordDetailsComponent;

    @Async("asyncExecutor")
    public Future<List<RecordDTO>> calculatenamewiseScore(String queryCustomer, double matchingScore, Integer searchId,List<OFACData> ofacdataList) {

        List<RecordDTO> listOfArrays = new ArrayList<>();
        String pepitizedQueryCustomer = pepitizeString(queryCustomer);

        for (OFACData ofacData : ofacdataList) {
            String pepitizedName = pepitizeString(ofacData.getName());

            double[] scores = calculateScores(pepitizedQueryCustomer, pepitizedName);

            if (algorithmRule.isCriminalRulePassed(scores[0], scores[1], scores[2], scores[3], matchingScore)) {
                double maxScore = findMaxScore(scores);

                RecordDTO recordDTO = createRecordDTO(ofacData, searchId, maxScore);
                listOfArrays.add(recordDTO);
            }
        }
        return new AsyncResult<>(listOfArrays);
    }

    private String pepitizeString(String input) {
        return input.replaceAll(",", " ")
                .replaceAll("[^a-zA-Z0-9\\s]", "")
                .replaceAll("[-+^]*", "")
                .toLowerCase();
    }

    private double[] calculateScores(String queryCustomer, String str2) {
        double[] scores = new double[4];
        scores[0] = safeCalculate(() -> round(Oneside.onesideMatching(queryCustomer, str2), 0), "oneside", queryCustomer, str2);
        scores[1] = safeCalculate(() -> round(ExactMatch.ExactMatching(queryCustomer, str2), 0), "exactMatch", queryCustomer, str2);
        scores[2] = safeCalculate(() -> round(Jarowinkler_Match.getJarowinklerMatching(queryCustomer, str2), 0), "Jarowinkler_Match", queryCustomer, str2);
        scores[3] = safeCalculate(() -> round(Fuzzy_WeightedRatio.Fuzzy_WeightedRatio(queryCustomer, str2), 0), "Fuzzy_WeightedRatio", queryCustomer, str2);
        return scores;
    }

    private double safeCalculate(Supplier<Double> calculation, String type, String queryCustomer, String str2) {
        try {
            return calculation.get();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(type + ":" + queryCustomer + " " + str2 + "  " + e);
            return 0;
        }
    }

    private double findMaxScore(double[] scores) {
        double maxScore = scores[0];
        for (double score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }

    private RecordDTO createRecordDTO(OFACData ofacData, Integer searchId, double score) {
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setIds(ofacData.getId());
        recordDTO.setNAME(ofacData.getName());
        recordDTO.setSearchId(searchId);
        recordDTO.setScore(score);
        return recordDTO;
    }

    private double round(double value, int places) {
        return value;
    }

    @FunctionalInterface
    private interface Supplier<T> {
        T get() throws IndexOutOfBoundsException;
    }

    @Async("asyncExecutor")
    public Future<List<RecordDTO>> getRecordDetails(Integer searchId, List<RecordDTO> recordDTOList) {

        List<Future<RecordDTO>> futures = recordDTOList.stream()
                .map(recordDTO -> processRecordDTOAsync(searchId, recordDTO))
                .collect(Collectors.toList());

        List<RecordDTO> recordDTOS = futures.stream()
                .map(this::getFutureResult)
                .collect(Collectors.toList());

        return new AsyncResult<>(recordDTOS);
    }
    @Async("asyncExecutor")
    public Future<RecordDTO> processRecordDTOAsync(Integer searchId, RecordDTO recordDTO) {
        try {
            RecordDTO newRecordDTO = processRecord(recordDTO, searchId);
            return new AsyncResult<>(newRecordDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new AsyncResult<>(null);
        }
    }

    private RecordDTO processRecord(RecordDTO recordDTO, Integer searchId) throws Exception {
        CreateHitRecordRequest request = createHitRecordRequest(searchId, recordDTO);
        Response hitResponse = createHitDataAsync(request).get();

        RecordDTO newRecordDTO = copyProperties(recordDTO);
        newRecordDTO.setHitId((Integer) hitResponse.getId());

        updateRecordDTOIfNeeded(recordDTO, newRecordDTO);
        return newRecordDTO;
    }

    private CreateHitRecordRequest createHitRecordRequest(Integer searchId, RecordDTO recordDTO) {
        CreateHitRecordRequest request = new CreateHitRecordRequest();
        request.setName(recordDTO.getNAME());
        request.setSearchId(searchId);
        request.setCriminalId(recordDTO.getIds());
        request.setDisplay("P" + recordDTO.getIds());
        request.setFileType(recordDTO.getFileType());
        request.setMatchingScore(recordDTO.getScore());
        request.setCycleId(1);
        request.setStatusNowId(0);
        return request;
    }

    private RecordDTO copyProperties(RecordDTO source) {
        RecordDTO target = new RecordDTO();
        target.setIds(source.getIds());
        target.setSearchId(source.getSearchId());
        target.setCriminalId(source.getIds());
        target.setNAME(source.getNAME());
        target.setFileType(source.getFileType());
        target.setFileList(source.getFileList());
        target.setScore(source.getScore());
        return target;
    }

    private void updateRecordDTOIfNeeded(RecordDTO source, RecordDTO target) throws ExecutionException, InterruptedException {
        if (source.getFileType() == 1) {
            recordReadService.updateRecordDTO(recordDetailsComponent, source.getIds(), target);
        }
        if (source.getFileType() == 2) {
        }
    }

    private RecordDTO getFutureResult(Future<RecordDTO> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Async("asyncExecutor")
    public Future<Response> createHitDataAsync(CreateHitRecordRequest request) {
        return new AsyncResult<>(hitRecordWritePlatformService.createHitRecord(request));
    }
}
