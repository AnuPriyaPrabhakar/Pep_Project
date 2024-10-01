package com.ponsun.pep.master.RelativeConfig.services;

import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfig;

import java.util.List;

public interface RelativeConfigReadPlatformService {
    List<RelativeConfig> fetchAllRelative();

    RelativeConfig fetchRelativeById(Integer id);
}
