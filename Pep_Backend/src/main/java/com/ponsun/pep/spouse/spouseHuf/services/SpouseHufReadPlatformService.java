package com.ponsun.pep.spouse.spouseHuf.services;

import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHuf;

import java.util.List;

public interface SpouseHufReadPlatformService {

    SpouseHuf fetchSpouseHufById(Integer id);

    List<SpouseHuf> fetchAllSpouseHuf();
}
