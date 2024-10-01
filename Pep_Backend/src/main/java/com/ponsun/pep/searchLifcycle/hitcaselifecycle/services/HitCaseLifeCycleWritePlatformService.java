package com.ponsun.pep.searchLifcycle.hitcaselifecycle.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.request.CreateHitCaseLifeCycleRequest;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.request.UpdateHitCaseLifeCycleRequest;

public interface HitCaseLifeCycleWritePlatformService {
    Response createHitCaseLifeCycle(CreateHitCaseLifeCycleRequest createHitCaseLifeCycleRequest);


    Response updateHitCaseLifeCycle(Integer id, UpdateHitCaseLifeCycleRequest updateHitCaseLifeCycleRequest);



    Response blockHitCaseLifeCycle(Integer id);

    Response unblockHitCaseLifeCycle(Integer id);
}
