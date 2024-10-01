package com.ponsun.pep.roles.RolesCommonService.service;


import com.ponsun.pep.roles.Role.data.RoleData;

import java.util.List;

public interface RoleCommonReadPlatformService {
    List<RoleData> fetchRoleData();
}
