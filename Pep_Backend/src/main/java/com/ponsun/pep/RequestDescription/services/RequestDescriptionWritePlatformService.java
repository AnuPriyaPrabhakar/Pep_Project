package com.ponsun.pep.RequestDescription.services;

import com.ponsun.pep.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.pep.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface RequestDescriptionWritePlatformService {
    Response createRequestDescription(CreateRequestDescriptionRequest createRequestDescriptionRequest);
    Response updateRequestDescription(Integer id, UpdateRequestDescriptionRequest updateRequestDescriptionRequest);
    Response blockRequestDescription(Integer id);
    Response unblockRequestDescription(Integer id);
}
