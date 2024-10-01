package com.ponsun.pep.adminconfiguration.adminuserrights.data;

import com.ponsun.pep.adminconfiguration.adminuserrights.request.UpdateAdminUserRightsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminUserRightsDataValidator {
    public void validateSaveAdminUserRights(final AdminUserRightsDTO request) {
        if (request.getModId() == null || request.getModId().equals("")) {
            throw new EQAS_PEP_AppicationException("AdminminUserRightsModeId parameter required");
        }
        if (request.getModDetId() == null || request.getModDetId().equals("")) {
            throw new EQAS_PEP_AppicationException("AdminminUserRightsModeDetId parameter required");
        }
    }
    public void validateUpdateAdminUserRights(final UpdateAdminUserRightsRequest request) {
        if (request.getModId() == null || request.getModId().equals("")) {
            throw new EQAS_PEP_AppicationException("AdminminUserRightsModeId parameter required");
        }
        if (request.getModDetId() == null || request.getModDetId().equals("")) {
            throw new EQAS_PEP_AppicationException("AdminminUserRightsModeDetId parameter required");
        }
    }
}
