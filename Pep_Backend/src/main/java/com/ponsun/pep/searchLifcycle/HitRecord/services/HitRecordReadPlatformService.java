package com.ponsun.pep.searchLifcycle.HitRecord.services;

import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordData;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecord;

import java.util.List;

public interface HitRecordReadPlatformService {
    HitRecord fetchAlHitRecordById(Integer id);
    List<HitRecordData> fetchAllHitRecordById(Integer searchId);
    List<HitRecordData> fetchAllSearchById(Integer searchId);
    List<HitRecord> fetchAll();
}
