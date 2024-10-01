package com.ponsun.pep.spouse.SpouseCommonService.service;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;

import java.util.List;

public interface SpouseCommonWriteService {

    Response createSpouseDetails(Integer pepId, List<SpouseCommonDTO> spouseCommonDTOS);
    Response createAndUpdateSpouseDetails(Integer pepId,Integer euid, List<SpouseCommonDTO> spouseCommonDTOS);
}
