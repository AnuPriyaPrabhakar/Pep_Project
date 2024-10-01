package com.ponsun.pep.spouse.spouseFather.services;

import com.ponsun.pep.spouse.spouseFather.domain.SpouseFather;

import java.util.List;

public interface SpouseFatherReadPlatformService {

    SpouseFather fetchSpouseFatherById(Integer id);

    List<SpouseFather> fetchAllSpouseFather();
}
