package com.ponsun.pep.spouse.spouseDetails.services;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseDetailsDTO;
import com.ponsun.pep.spouse.spouseDetails.request.CreateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.request.UpdateSpouseDetailsRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpouseDetailsWritePlatformService {
    Response createSpouseDetails(CreateSpouseDetailsRequest createSpouseDetailsRequest);

    Response updateSpouseDetails(Integer id, UpdateSpouseDetailsRequest updateSpouseDetailsRequest);

    List<SpouseDetailsDTO> fetchSpouseDetailsData(Integer pepId);

    Response DeActiveSpouse(Integer pepId, Integer euid);
}
