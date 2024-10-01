package com.ponsun.pep.familyDetails.FatherDetails.services;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FatherDTO;
import com.ponsun.pep.familyDetails.FatherDetails.request.CreateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.request.UpdateFatherDetailsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface FatherDetailsWritePlatFormService {
    Response createFatherDetails(CreateFatherDetailsRequest createFatherDetailsRequest);

    Response updateFatherDetailsList(Integer id, UpdateFatherDetailsRequest updateFatherDetailsRequest);

    List<FatherDTO> fetchFatherDTO(Integer pepId);

    Response DeActiveFamily(Integer pepId, Integer euid);

    // Response DeActiveFamily(Integer pepId, Integer euid);
}
