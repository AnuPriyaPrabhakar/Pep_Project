package com.ponsun.pep.master.District.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.District.request.CreateDistrictRequest;
import com.ponsun.pep.master.District.request.UpdateDistrictRequest;

public interface DistrictWritePlatformService {
    Response createDistrict(CreateDistrictRequest createDistrictRequest);

    Response updateDistrict(Integer id, UpdateDistrictRequest updateDistrictRequest);
    Response blockDistrict(Integer id);
    Response unblockDistrict(Integer id);
}
