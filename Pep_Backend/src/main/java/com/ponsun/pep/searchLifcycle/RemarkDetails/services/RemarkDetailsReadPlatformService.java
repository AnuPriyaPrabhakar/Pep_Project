package com.ponsun.pep.searchLifcycle.RemarkDetails.services;

import com.ponsun.pep.searchLifcycle.RemarkDetails.data.RemarkDetailsData;

import java.util.List;

public interface RemarkDetailsReadPlatformService {
    List<RemarkDetailsData>fetchAllRemark(Integer hitdataId);
}
