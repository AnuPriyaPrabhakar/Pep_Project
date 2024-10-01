package com.ponsun.pep.adminconfiguration.adminconfigmodule.services;


import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModuleRepository;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModuleRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminConfigModuleReadPlatformServiceImpl implements AdminConfigModuleReadPlatformService {

    private final AdminConfigModuleRepository adminConfigModuleRepository;
    private final JdbcTemplate jdbcTemplate;
    private final AdminConfigModuleRepositoryWrapper adminConfigModuleRepositoryWrapper;

    @Override
    public AdminConfigModule fetchAdminConfigModuleById(Integer id){return this.adminConfigModuleRepository.findById(id).get();}
    @Override
    public List<AdminConfigModule> fetchAllAdminConfigModule(){return this.adminConfigModuleRepository.findAll();}
}


