package com.ponsun.pep.adminconfiguration.adminuserrights.services;

import com.ponsun.pep.adminconfiguration.adminuserrights.domain.AdminUserRights;

import java.util.List;

public interface AdminUserRightsReadPlatformService {

    AdminUserRights fetchAdminUserRightsById (Integer id);
    List<AdminUserRights> fetchAllAdminUserRights();
}
