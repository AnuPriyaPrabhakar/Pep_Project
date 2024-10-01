package com.ponsun.pep.nameSearch.Count.service;

import com.ponsun.pep.dto.RecordDTO;

import java.util.concurrent.ExecutionException;

public interface RecordReadService {
    void updateRecordDTO(RecordDetails recordDetails, Integer id, RecordDTO recordDTO) throws ExecutionException, InterruptedException;

}