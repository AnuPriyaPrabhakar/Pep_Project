package com.ponsun.pep.roles.RolesCommonService.service;

import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.data.RoleDataValidator;
import com.ponsun.pep.roles.Role.domain.Role;
import com.ponsun.pep.roles.Role.domain.RoleRepository;
import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.rowmapper.RoleRowMapper;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetails;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetailsRepository;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleCommonWritePlatformServiceImpl implements RoleCommonWritePlatformService {
    private final RoleRepository roleRepository;
    private final RoleDetailsRepository roleDetailsRepository;
    private final RoleDataValidator roleDataValidator;


    @Override
    public Response createRoleDetails(CreateRoleRequest createRoleRequest) {
        try {
            this.roleDataValidator.validateSaveRole(createRoleRequest);
            final Role role = Role.create(createRoleRequest);
            final AdminConfigModule adminConfigModule = AdminConfigModule.create(new CreateAdminConfigModuleRequest());
            this.roleRepository.saveAndFlush(role);
            Integer modId = adminConfigModule.getId();
            Integer roleId = role.getId();
            RoleDetails roleDetails = new RoleDetails();
            roleDetails.setRoleId(roleId);
            roleDetails.setModId(modId);
            roleDetails.setStatus(Status.ACTIVE);
            roleDetailsRepository.saveAndFlush(roleDetails);
            return Response.of(roleId);
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public Response createAndUpdateRoleDetails(Integer roleId, CreateRoleRequest createRoleRequest) {
        try {
            this.roleDataValidator.validateSaveRole(createRoleRequest);
            Role existingRole = roleRepository.findById(roleId).orElse(null);
            if (existingRole != null) {
                existingRole.setStatus(Status.DELETE);
                roleRepository.saveAndFlush(existingRole);
            }

            final Role roles = Role.create(createRoleRequest);
            this.roleRepository.saveAndFlush(roles);
            Integer newRoleId = roles.getId();

            RoleDetails roleDetails = new RoleDetails();
            roleDetails.setRoleId(newRoleId);
            roleDetails.setStatus(Status.ACTIVE);
            roleDetailsRepository.saveAndFlush(roleDetails);

            return Response.of(newRoleId);
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


}
