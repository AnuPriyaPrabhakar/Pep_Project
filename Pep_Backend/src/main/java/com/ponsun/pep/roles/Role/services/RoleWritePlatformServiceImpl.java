package com.ponsun.pep.roles.Role.services;


import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.data.RoleDataValidator;
import com.ponsun.pep.roles.Role.domain.Role;
import com.ponsun.pep.roles.Role.domain.RoleRepository;
import com.ponsun.pep.roles.Role.domain.RoleRepositoryWrapper;
import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.roles.Role.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleWritePlatformServiceImpl implements  RoleWritePlatformService{
    private final RoleRepository roleRepository;
    private final RoleRepositoryWrapper roleRepositoryWrapper;
    private final RoleDataValidator roleDataValidator;
    private final RoleRowMapper roleRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createRole(CreateRoleRequest createRoleRequest) {
        try {
            this.roleDataValidator.validateSaveRole(createRoleRequest);
            final Role role = Role.create(createRoleRequest);
            this.roleRepository.saveAndFlush(role);
            return Response.of(Long.valueOf(role.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateRole(Integer id, UpdateRoleRequest updateRoleRequest) {
        try {
            this.roleDataValidator.validateUpdateRole(updateRoleRequest);
            final Role role = this.roleRepositoryWrapper.findOneWithNotFoundDetection(id);
            role.update(updateRoleRequest);
            this.roleRepository.saveAndFlush(role);
            return Response.of(Long.valueOf(role.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }



}
