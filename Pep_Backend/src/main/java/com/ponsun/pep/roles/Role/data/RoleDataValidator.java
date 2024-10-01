package com.ponsun.pep.roles.Role.data;

import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleDataValidator {

    public void validateSaveRole(final CreateRoleRequest request) {
        if (request.getRoleName() == null || request.getRoleName().equals("")) {
            throw new EQAS_PEP_AppicationException("Role parameter required");
        }
    }
    public void validateUpdateRole(final UpdateRoleRequest request) {
        if (request.getRoleName() == null || request.getRoleName().equals("")) {
            throw new EQAS_PEP_AppicationException("Role parameter required");
        }
    }
}
