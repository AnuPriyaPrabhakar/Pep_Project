package com.ponsun.pep.master.RelativeConfig.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.RelativeConfig.request.CreateRelativeRequest;
import com.ponsun.pep.master.RelativeConfig.request.UpdateRelativeRequest;

public interface RelativeConfigWritePlatformService {
    Response createRelative(CreateRelativeRequest createRelativeRequest);

    Response updateRelative(Integer id, UpdateRelativeRequest updateRelativeRequest);

    Response deleteRelative(Integer id);
}
