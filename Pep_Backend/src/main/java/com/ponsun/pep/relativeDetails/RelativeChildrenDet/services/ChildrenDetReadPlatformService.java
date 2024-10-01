package com.ponsun.pep.relativeDetails.RelativeChildrenDet.services;

import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;


import java.util.List;

public interface ChildrenDetReadPlatformService {
    ChildrenDet fetchChildrenDetById(Integer id);

    List<ChildrenDet> fetchAllChildrenDet();
}
