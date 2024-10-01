package com.ponsun.pep.adminconfiguration.adminuserauthority.data;

import com.ponsun.pep.adminconfiguration.adminuserauthority.request.CreateAdminUserAuthorityRequest;
import com.ponsun.pep.adminconfiguration.adminuserauthority.request.UpdateAdminUserAuthorityRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminUserAuthorityDataValidator {
    public void validateSaveAdminUserAuthority(final CreateAdminUserAuthorityRequest request){
        if (request.getRoleCode()==null || request.getRoleCode().equals("")){
            throw new EQAS_PEP_AppicationException("AdminUserAuthorityRoleCode parameter required");
        }
        if (request.getRoleDescription()==null || request.getRoleDescription().equals("")){
            throw new EQAS_PEP_AppicationException("AdminUserAuthorityRoleDescription parameter required");
        }
    }
    public void validateUpdateAdminUserAuthority(final UpdateAdminUserAuthorityRequest request){
        if (request.getRoleCode()==null || request.getRoleCode().equals("")){
            throw new EQAS_PEP_AppicationException("AdminUserAuthorityRoleCode parameter required");
        }
        if (request.getRoleDescription()==null || request.getRoleDescription().equals("")){
            throw new EQAS_PEP_AppicationException("AdminUserAuthorityRoleDescription parameter required");
        }
    }
}
