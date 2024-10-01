package com.ponsun.pep.familyDetails.HufDetails.services;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.HufDTO;
import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.request.UpdateHufDetailsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface HufDetailsWritePlatFormService {
    Response createHufDetails(CreateHufDetailsRequest createHufDetailsRequest);

    Response updateHufDetailsList(Integer id, UpdateHufDetailsRequest updateHufDetailsRequest);

    List<HufDTO> fetchHufDTO(Integer pepId);
}
