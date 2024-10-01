package com.ponsun.pep.familyDetails.FatherDetails.services;

import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetails;

import java.util.List;

public interface FatherDetailsReadPlatFormService {
    List<FatherDetails> fetchAllFatherDetails();
    FatherDetails fetchFatherDetailsById(Integer id);
}
