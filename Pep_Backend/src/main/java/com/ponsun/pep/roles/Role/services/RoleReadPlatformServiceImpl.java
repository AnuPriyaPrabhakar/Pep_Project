package com.ponsun.pep.roles.Role.services;


import com.ponsun.pep.roles.Role.domain.Role;
import com.ponsun.pep.roles.Role.domain.RoleRepository;
import com.ponsun.pep.roles.Role.domain.RoleRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RoleReadPlatformServiceImpl implements RoleReadPlatformService {
    private final RoleRepositoryWrapper roleRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RoleRepository roleRepository;

    @Override
    public Role fetchRoleById(Integer id) {
        return this.roleRepository.findById(id).get();
    }
    @Override
    public List<Role> fetchAllRole() {
        return this.roleRepository.findAll();
    }
}