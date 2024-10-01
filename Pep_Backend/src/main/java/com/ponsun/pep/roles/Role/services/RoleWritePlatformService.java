package com.ponsun.pep.roles.Role.services;

import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface RoleWritePlatformService {
    Response createRole(CreateRoleRequest createRoleRequest);

    Response updateRole(Integer id, UpdateRoleRequest updateRoleRequest);


}
