package com.ponsun.pep.searchLifcycle.hitcase.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.hitcase.request.CreateHitCaseRequest;
import com.ponsun.pep.searchLifcycle.hitcase.request.UpdateHitCaseRequest;

public interface HitCaseWritePlatformService {
    Response CreateHitcase(CreateHitCaseRequest createHitCaseRequest);

    Response updateHitcase(Integer id, UpdateHitCaseRequest updateHitCaseRequest);

    Response blockHitcase(Integer id);

    Response unblockHitcase(Integer id);
}
