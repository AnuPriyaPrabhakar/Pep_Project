package com.ponsun.pep.familyDetails.HufDetails.services;

import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetails;

import java.util.List;

public interface HufDetailsReadPlatFormService {
    List<HufDetails> fetchAllHufDetails();

    HufDetails fetchHufDetailsById(Integer id);
}
