package com.ponsun.pep.relativeDetails.Relative.services;

import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.relativeDetails.Relative.domain.Relative;

import java.util.List;

public interface RelativeReadPlatformService {

    List<RelativeData> fetchRelativeByPepId(Integer pepId);
    List<Relative>fetchAllRelative();
}
