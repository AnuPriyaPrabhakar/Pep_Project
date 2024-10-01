package com.ponsun.pep.spouse.spouseDetails.services;

import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetails;

import java.util.List;

public interface SpouseDetailsReadPlatformService {
    SpouseDetails fetchSpouseDetailsById(Integer id);

    List<SpouseDetails> fetchAllSpouseDetails();
}
