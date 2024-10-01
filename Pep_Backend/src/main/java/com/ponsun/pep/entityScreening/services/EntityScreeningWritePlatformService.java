package com.ponsun.pep.entityScreening.services;

import com.ponsun.pep.entityScreening.data.EntityScreeningData;

import java.util.List;

public interface EntityScreeningWritePlatformService {
    List<EntityScreeningData> fetchAllEntityScreening(Integer kycId);
}
