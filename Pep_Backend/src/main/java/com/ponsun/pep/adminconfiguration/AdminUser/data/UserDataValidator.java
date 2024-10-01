package com.ponsun.pep.adminconfiguration.AdminUser.data;

import com.ponsun.pep.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.pep.adminconfiguration.AdminUser.request.UpdateUserRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDataValidator {

    public void validateSaveModuleDet(final CreateUserRequest request) {
        if (request.getFullName() == null || request.getFullName().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateUserRequest request) {
        if (request.getFullName() == null || request.getFullName().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
}
