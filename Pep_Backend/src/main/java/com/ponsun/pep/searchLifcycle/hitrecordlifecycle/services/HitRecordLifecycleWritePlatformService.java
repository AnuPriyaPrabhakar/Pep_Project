package com.ponsun.pep.searchLifcycle.hitrecordlifecycle.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.hitrecordlifecycle.request.CreateHitRecordLifecycle;
import com.ponsun.pep.searchLifcycle.hitrecordlifecycle.request.UpdateHitdataLifecycleRequest;

public interface HitRecordLifecycleWritePlatformService {
    Response createHitdataLifecycle(CreateHitRecordLifecycle createHitRecordLifecycle);
    //Response l2_createHitdataLifecycle(CreateHitdataLifecycle createHitdataLifecycle);
    Response updateHitdataLifecycle(Integer id, UpdateHitdataLifecycleRequest updateHitdataLifecycleRequest);
    Response blockHitdataLifecycle(Integer id);
    Response unblockHitdataLifecycle(Integer id);
}
