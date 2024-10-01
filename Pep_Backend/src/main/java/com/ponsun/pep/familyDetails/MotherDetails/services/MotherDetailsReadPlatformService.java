package com.ponsun.pep.familyDetails.MotherDetails.services;

import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetails;

import java.util.List;

public interface MotherDetailsReadPlatformService {
    MotherDetails fetchMotherDetailsById(Integer id);

    List<MotherDetails> fetchAllMotherDetails();
}
