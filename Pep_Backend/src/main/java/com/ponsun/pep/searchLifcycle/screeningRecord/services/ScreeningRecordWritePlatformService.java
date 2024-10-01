package com.ponsun.pep.searchLifcycle.screeningRecord.services;

import com.ponsun.pep.searchLifcycle.screeningRecord.data.ScreeningRecordData;

import java.util.List;

public interface ScreeningRecordWritePlatformService {
    List<ScreeningRecordData> fetchAllScreeningRecord(Integer id);
}
