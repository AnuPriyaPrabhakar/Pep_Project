package com.ponsun.pep.relativeDetails.Relative.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.request.UpdateRelativeRequest;

import java.util.List;

public interface RelativeWritePlatformService {
    Response createRelative(CreateRelativeRequest createRelativeRequest);
    Response updateRelative(Integer id, UpdateRelativeRequest updateRelativeRequest);

    Response blockRelative(Integer id);
    Response DeactiveRelative(Integer pepId,Integer euid);


//    Response DeactiveRelative(Integer pepId, Integer relativeMasterId, Integer euid, Integer relativeId);

    Response unblockRelative(Integer id);

    List<RelativeData> fetchRelativeData(Integer pepId);

//    Response deActive(Integer pepId, Integer euid);
}
