package com.ponsun.pep.searchLifcycle.hitrecordlifecycle.services;


import com.ponsun.pep.searchLifcycle.hitrecordlifecycle.domain.HitRecordLifecycle;

import java.util.List;

public interface HitRecordLifecycleReadPlatformService {


    HitRecordLifecycle fetchAllHitdataLifecycle(Integer id);

    HitRecordLifecycle fetchHitdataLifecycleById(Integer id);

    List<HitRecordLifecycle> fetchAllHitdataLifecycle();
}
