package com.ponsun.pep.levelOneRemark.services;

import com.ponsun.pep.levelOneRemark.data.LevelOneRemarkData;

import java.util.List;

public interface LevelOneRemarkWritePlatformService {
    List<LevelOneRemarkData> fetchAllLevelOneRemark(Integer criminalId,Integer hitdataId,Integer levelId,Integer statusId);
    List<LevelOneRemarkData> fetchAllRIF(Integer levelId,Integer statusId);
}
