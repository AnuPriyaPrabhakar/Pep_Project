package com.ponsun.pep.spouse.SpouseCommonService.service;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;

import java.util.List;

public interface SpouseCommonReadService {
    List<SpouseCommonDTO> getSpouseDetails(Integer pepId);
}
