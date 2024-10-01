package com.ponsun.pep.requestForUpdate.services;

import com.ponsun.pep.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.pep.requestForUpdate.request.UpdateRequestForUpdateRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface RequestForUpdateWritePlatformService {
    Response createRequestForUpdateRequest(CreateRequestForUpdateRequest createRequestForUpdateRequest);

    Response updateRequestForUpdate(Integer id, UpdateRequestForUpdateRequest updateRequestForUpdateRequest);
}
