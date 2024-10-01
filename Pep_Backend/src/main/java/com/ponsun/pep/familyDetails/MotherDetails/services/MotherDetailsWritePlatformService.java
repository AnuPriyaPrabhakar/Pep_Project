package com.ponsun.pep.familyDetails.MotherDetails.services;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.MotherDTO;
import com.ponsun.pep.familyDetails.MotherDetails.request.CreateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.request.UpdateMotherDetailsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface MotherDetailsWritePlatformService {
    Response createMotherDetails(CreateMotherDetailsRequest createMotherDetailsRequest);

    Response updateMotherDetails(Integer id, UpdateMotherDetailsRequest updateMotherDetailsRequest);

    List<MotherDTO> fetchMotherDTO(Integer pepId);
}
