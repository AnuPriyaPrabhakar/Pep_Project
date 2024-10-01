package com.ponsun.pep.roles.RoleDetails.services;


import com.ponsun.pep.roles.RoleDetails.domain.RoleDetails;

import java.util.List;

public interface RoleDetailsReadPlatformService {
    RoleDetails fetchRoleDetailsById(Integer id);
    List<RoleDetails> fetchAllRoleDetails();
}
