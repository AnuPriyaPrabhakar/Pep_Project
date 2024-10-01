package com.ponsun.pep.spouse.spouseMother.services;

import com.ponsun.pep.spouse.spouseMother.domain.SpouseMother;

import java.util.List;

public interface SpouseMotherReadPlatformService {

    SpouseMother fetchSpouseMotherById(Integer id);

    List<SpouseMother> fetchAllSpouseMother();
}
