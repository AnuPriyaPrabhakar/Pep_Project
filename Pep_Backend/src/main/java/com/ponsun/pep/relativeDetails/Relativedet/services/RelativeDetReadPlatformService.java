package com.ponsun.pep.relativeDetails.Relativedet.services;

import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;

import java.util.List;

public interface RelativeDetReadPlatformService {

    RelativeDet fetchRelativeDetById(Integer id);

    List<RelativeDet> fetchAllRelativeDet();
}
