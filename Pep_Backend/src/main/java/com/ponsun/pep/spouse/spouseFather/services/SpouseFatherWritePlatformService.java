package com.ponsun.pep.spouse.spouseFather.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseFatherDTO;
import com.ponsun.pep.spouse.spouseFather.request.CreateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.request.UpdateSpouseFatherRequest;

import java.util.List;

public interface SpouseFatherWritePlatformService {
    Response createSpouseFather(CreateSpouseFatherRequest createCountryRequest);
    Response updateSpouseFather(Integer id, UpdateSpouseFatherRequest updateSpouseFatherRequest);
    Response blockSpouseFather(Integer id);
    Response unblockSpouseFather(Integer id);
    List<SpouseFatherDTO> fetchSpouseFatherDTO(Integer pepId, Integer spouseId);
}
