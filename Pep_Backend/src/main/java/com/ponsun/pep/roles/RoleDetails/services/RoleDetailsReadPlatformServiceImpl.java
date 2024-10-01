package com.ponsun.pep.roles.RoleDetails.services;

import com.ponsun.pep.roles.RoleDetails.domain.RoleDetails;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetailsRepository;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleDetailsReadPlatformServiceImpl implements RoleDetailsReadPlatformService{
    private final RoleDetailsRepositoryWrapper roleDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RoleDetailsRepository roleDetailsRepository;

    @Override
    public RoleDetails fetchRoleDetailsById(Integer id) {

        return this.roleDetailsRepository.findById(id).get();

    }

    @Override
    public List<RoleDetails> fetchAllRoleDetails() {
        return this.roleDetailsRepository.findAll();
    }
}
