package com.ponsun.pep.spouse.spouseMother.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseMotherDTO;
import com.ponsun.pep.spouse.spouseMother.request.CreateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.request.UpdateSpouseMotherRequest;

import java.util.List;

public interface SpouseMotherWritePlatformService {
    Response createSpouseMother(CreateSpouseMotherRequest createCountryRequest);
    Response updateSpouseMother(Integer id, UpdateSpouseMotherRequest updateSpouseMotherRequest);
    Response blockSpouseMother(Integer id);
    Response unblockSpouseMother(Integer id);

    List<SpouseMotherDTO> fetchSpouseMotherDTO(Integer pepId, Integer spouseId);
}
