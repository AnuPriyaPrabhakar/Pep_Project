package com.ponsun.pep.roles.RoleDetails.services;

import com.ponsun.pep.roles.RoleDetails.request.CreateRoleDetailsRequest;
import com.ponsun.pep.roles.RoleDetails.request.UpdateRoleDetailsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface RoleDetailsWritePlatformService {
    Response createRoleDetails(CreateRoleDetailsRequest createRoleDetailsRequest);
    Response updateRoleDetails(Integer id, UpdateRoleDetailsRequest updateRoleDetailsRequest);
    Response blockRoleDetails(Integer id);
    Response unblockRoleDetails(Integer id);
//    Response deactive(Integer pepId, Integer euid);
}
