package com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.services;

import org.springframework.stereotype.Service;

@Service
public interface PepRelativeDetWritePlatformService {
    String insertPepRelativeDet(Integer pepId, Integer relativeMasterId, String allMemberDet, Integer ipCreatedBy);
}
