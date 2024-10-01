package com.ponsun.pep.searchLifcycle.hitcaselifecycle.services;

import com.ponsun.pep.searchLifcycle.hitcaselifecycle.domain.HitcaseLifecycle;

import java.util.List;

public interface HitCaseLifeCycleReadPlatformService {


    HitcaseLifecycle fetchHitcaseLifeById(Integer id);

    List<HitcaseLifecycle> fetchAllHitcaseLife();
}
