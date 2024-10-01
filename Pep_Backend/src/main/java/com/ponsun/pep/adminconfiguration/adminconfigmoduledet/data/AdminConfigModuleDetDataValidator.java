package com.ponsun.pep.adminconfiguration.adminconfigmoduledet.data;

import com.ponsun.pep.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.pep.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDetDataValidator {
    public void validateSaveModuleDet(final CreateAdminConfigModuleDetRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateAdminConfigModuleDetRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
}