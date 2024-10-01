package com.ponsun.pep.roles.RoleDetails.data;

import com.ponsun.pep.roles.RoleDetails.request.CreateRoleDetailsRequest;
import com.ponsun.pep.roles.RoleDetails.request.UpdateRoleDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleDetailsDataValidator {
    public void validateSaveRoleDetails(final CreateRoleDetailsRequest request) {
        if (request.getRoleId() == null || request.getRoleId().equals("")) {
            throw new EQAS_PEP_AppicationException("roleId parameter required");
        }
    }
    public void validateUpdateRoleDetails(final UpdateRoleDetailsRequest request) {
        if (request.getRoleId() == null || request.getRoleId().equals("")) {
            throw new EQAS_PEP_AppicationException("RoleId parameter required");
        }
    }
}
