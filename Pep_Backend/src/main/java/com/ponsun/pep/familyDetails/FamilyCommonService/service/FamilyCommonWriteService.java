package com.ponsun.pep.familyDetails.FamilyCommonService.service;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;

import java.util.List;

public interface FamilyCommonWriteService {
    Response createFamilyDetails(Integer pepId, List<FamilyCombinedDTO> familyCombinedDTOS);
    Response createAndUpdateFamilyDetails(Integer pepId,Integer euid, List<FamilyCombinedDTO> familyCombinedDTOS);

}
