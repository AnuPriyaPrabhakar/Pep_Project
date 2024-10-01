package com.ponsun.pep.roles.RolesCommonService.service;

import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;

import java.util.List;


public interface RoleCommonWritePlatformService {
    Response createRoleDetails(CreateRoleRequest createRoleRequest);

    Response createAndUpdateRoleDetails(Integer roleId, CreateRoleRequest createRoleRequest);

}
