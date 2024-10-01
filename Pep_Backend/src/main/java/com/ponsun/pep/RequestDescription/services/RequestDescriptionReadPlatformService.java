package com.ponsun.pep.RequestDescription.services;

import com.ponsun.pep.RequestDescription.domain.RequestDescription;

import java.util.List;

public interface RequestDescriptionReadPlatformService {
    RequestDescription fetchRequestDescriptionById(Integer id);
    List<RequestDescription> fetchAllRequestDescription();
}
