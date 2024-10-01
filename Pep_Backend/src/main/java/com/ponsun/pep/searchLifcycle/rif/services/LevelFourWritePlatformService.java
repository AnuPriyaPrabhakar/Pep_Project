package com.ponsun.pep.searchLifcycle.rif.services;

import com.ponsun.pep.searchLifcycle.rif.data.LevelFourData;

import java.util.List;

public interface LevelFourWritePlatformService {
    List<LevelFourData> fetchAllLevelFourData(Integer levelId);
}
