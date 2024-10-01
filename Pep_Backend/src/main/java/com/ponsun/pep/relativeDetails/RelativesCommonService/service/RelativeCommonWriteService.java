package com.ponsun.pep.relativeDetails.RelativesCommonService.service;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface RelativeCommonWriteService {
    // String createRelative(Integer pepId, Integer relativeMasterId, String allMemberDet, Integer createdBy);
    Response createRelativeDetails(Integer pepId, List<RelativeCombineDTO> relativeCombineDTO);
    Response createAndUpdateRelativeDetails(Integer pepId,Integer uid, List<RelativeCombineDTO> relativeCombineDTO);

}
