package com.ponsun.pep.adminconfiguration.adminuserauthority.service;


import com.ponsun.pep.adminconfiguration.adminuserauthority.request.CreateAdminUserAuthorityRequest;
import com.ponsun.pep.adminconfiguration.adminuserauthority.request.UpdateAdminUserAuthorityRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface AdminUserAuthorityWritePlatformService {
    Response createAdminUserAuthority(CreateAdminUserAuthorityRequest createAdminUserAuthorityRequest);
    Response updateAdminUserAuthority(Integer id, UpdateAdminUserAuthorityRequest updateAdminUserAuthorityRequest);
    Response blockAdminUserAuthority(Integer id);
    Response unblockAdminUserAuthority(Integer id);
}
