package com.ponsun.pep.master.gender.services;



import com.ponsun.pep.master.gender.domain.Gender;

import java.util.List;

public interface GenderReadPlatformService {

    Gender fetchGenderById(Integer id);

    List<Gender> fetchAllGender();
}
