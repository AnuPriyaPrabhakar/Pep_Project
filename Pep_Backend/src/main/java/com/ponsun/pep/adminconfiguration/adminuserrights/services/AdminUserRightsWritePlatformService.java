package com.ponsun.pep.adminconfiguration.adminuserrights.services;

import com.ponsun.pep.adminconfiguration.adminuserrights.data.AdminUserRightsDTO;
import com.ponsun.pep.adminconfiguration.adminuserrights.request.UpdateAdminUserRightsRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminUserRightsWritePlatformService {

    @Transactional
    List<String> createAdminUserRights(List<AdminUserRightsDTO> createAdminUserRightsRequests);

    Response updateAdminUserRights(Integer id, UpdateAdminUserRightsRequest updateAdminUserRightsRequest);

    Response blockAdminUserRights(Integer id);
    Response unblockAdminUserRights(Integer id);
}
