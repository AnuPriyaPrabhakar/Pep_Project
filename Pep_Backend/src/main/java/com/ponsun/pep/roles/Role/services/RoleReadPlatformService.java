package com.ponsun.pep.roles.Role.services;


import com.ponsun.pep.roles.Role.domain.Role;

import java.util.List;

public interface RoleReadPlatformService {
    List<Role> fetchAllRole();

    Role fetchRoleById(Integer id);
}
