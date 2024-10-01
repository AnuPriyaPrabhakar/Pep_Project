package com.ponsun.pep.adminconfiguration.adminuserauthority.service;

import com.ponsun.pep.adminconfiguration.adminuserauthority.domain.AdminUserAuthority;

import java.util.List;

public interface AdminUserAuthorityReadPlatformService {
    AdminUserAuthority fetchAdminUserAuthorityById (Integer id);
    List<AdminUserAuthority> fetchAllAdminUserAuthority();
}
