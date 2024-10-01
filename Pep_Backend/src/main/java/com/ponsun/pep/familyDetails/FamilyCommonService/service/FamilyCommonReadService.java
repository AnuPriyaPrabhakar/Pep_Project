package com.ponsun.pep.familyDetails.FamilyCommonService.service;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;

import java.util.List;

public interface FamilyCommonReadService {

    List<FamilyCombinedDTO> getFamilyDetails(Integer id);
}
