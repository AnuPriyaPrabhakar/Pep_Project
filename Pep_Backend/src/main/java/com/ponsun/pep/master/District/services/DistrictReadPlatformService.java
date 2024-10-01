package com.ponsun.pep.master.District.services;

import com.ponsun.pep.master.District.domain.District;
import java.util.List;

public interface DistrictReadPlatformService {
    List<District> fetchAllDistrict();
    District fetchDistrictById(Integer id);
}
