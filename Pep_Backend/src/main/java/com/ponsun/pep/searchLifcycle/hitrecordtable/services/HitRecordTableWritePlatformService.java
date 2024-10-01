package com.ponsun.pep.searchLifcycle.hitrecordtable.services;
import com.ponsun.pep.searchLifcycle.hitrecordtable.data.HitRecordDataTableData;

import java.util.List;

public interface HitRecordTableWritePlatformService {
    List<HitRecordDataTableData> fetchAllHitDataTableData(String levelId);
}
