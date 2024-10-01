package com.ponsun.pep.searchLifcycle.hitcase.services;

import com.ponsun.pep.searchLifcycle.hitcase.domain.Hitcase;

import java.util.List;

public interface HitCaseReadPlatformService {
    List<Hitcase> fetchAllHitcase();
    Hitcase fetchHitcaseById(Integer id);



}
