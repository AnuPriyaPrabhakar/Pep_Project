package com.ponsun.pep.searchLifcycle.HitRecord.services;

import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecord;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.request.UpdateHitRecordRequest;

import java.util.List;
public interface HitRecordWritePlatformService {
    Response createHitRecord(CreateHitRecordRequest createHitRecordRequest);
    List<HitRecord> createlistodHitData(List<RecordDTO> uniqueListOfArrays,Integer uid);
    Response updateHitRecord(Integer id,UpdateHitRecordRequest updateHitRecordRequest);
    Response blockHitRecord(Integer id);
    Response unblockHitRecord(Integer id);
}
