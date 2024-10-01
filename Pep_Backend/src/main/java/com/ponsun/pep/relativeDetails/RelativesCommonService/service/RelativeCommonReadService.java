package com.ponsun.pep.relativeDetails.RelativesCommonService.service;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;

import java.util.List;

public interface RelativeCommonReadService {
    List<RelativeCombineDTO> getRelativeActivity(Integer id);
}
