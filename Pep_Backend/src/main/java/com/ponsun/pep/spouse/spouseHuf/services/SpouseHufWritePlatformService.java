package com.ponsun.pep.spouse.spouseHuf.services;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseHufDTO;
import com.ponsun.pep.spouse.spouseHuf.request.CreateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseHuf.request.UpdateSpouseHufRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface SpouseHufWritePlatformService {
    Response createSpouseHuf(CreateSpouseHufRequest createCountryRequest);
    Response updateSpouseHuf(Integer id, UpdateSpouseHufRequest updateSpouseHufRequest);
    Response blockSpouseHuf(Integer id);
    Response unblockSpouseHuf(Integer id);

    List<SpouseHufDTO> fetchSpouseHufDTO(Integer pepId, Integer spouseId);
}
