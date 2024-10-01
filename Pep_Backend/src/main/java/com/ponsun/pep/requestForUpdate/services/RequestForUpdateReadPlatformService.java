package com.ponsun.pep.requestForUpdate.services;

import com.ponsun.pep.requestForUpdate.domain.RequestForUpdate;

import java.util.List;

public interface RequestForUpdateReadPlatformService {
    List<RequestForUpdate> fetchAllRequestForUpdate();

    RequestForUpdate fetchRequestForUpdateById(Integer id);
}
