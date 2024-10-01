package com.ponsun.pep.relativeDetails.Relativedet.services;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.request.UpdateRelativeDetRequest;

import java.util.List;

public interface RelativeDetWritePlatformService {

    Response createRelativeDet(CreateRelativeDetRequest createRelativeDetRequest);
    Response updateRelativeDet(Integer id, UpdateRelativeDetRequest updateRelativeDetRequest);
    Response blockRelativeDet(Integer id);
    Response unblockRelativeDet(Integer id);

    Response deactive(Integer pepId, Integer euid);

//    List<RelativeDetDTO> fetchRelativeDetDTO(Integer pepId);
List<RelativeDetDTO> fetchRelativeDetDTO(Integer pepId,Integer relativeId);
}
