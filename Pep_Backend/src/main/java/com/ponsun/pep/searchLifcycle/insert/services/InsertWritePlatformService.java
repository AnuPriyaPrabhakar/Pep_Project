package com.ponsun.pep.searchLifcycle.insert.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.PendingCase.data.PendingCaseData;
import com.ponsun.pep.searchLifcycle.hitcase.request.CreateHitCaseRequest;

public interface InsertWritePlatformService {
    Response CreateHitCase_HitrecordLifeCycle(CreateHitCaseRequest createHitCaseRequest);
    Response insertPendingCaseData(PendingCaseData pendingCaseData);

    void updateValidFlag(Integer searchId, Integer criminalId,Integer hitId);
    void updateHitDataStatus(Integer hitId);
}
