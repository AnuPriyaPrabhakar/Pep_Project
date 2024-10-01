package com.ponsun.pep.relativeDetails.RelativeChildrenDet.services;

import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.UpdateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface ChildrenDetWritePlatformService {
    Response createChildrenDet(CreateChildrenDetRequest createChildrenDetRequest);

    Response updateChildrenDet(Integer id, UpdateChildrenDetRequest updateChildrenDetRequest);

    Response deleteChildrenDet(Integer id);

    Response deactive(Integer pepId, Integer euid);

//    List<RelativeChildrenDTO> fetchRelativeChildrenDTO(Integer pepId);
List<RelativeChildrenDTO> fetchRelativeChildrenDTO(Integer pepId,Integer relativeId);
}
