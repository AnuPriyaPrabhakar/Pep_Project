package com.ponsun.pep.master.CompanyMaster.service;

import com.ponsun.pep.master.CompanyMaster.domain.CompanyMasterRepositoryWrapperMaster;
import com.ponsun.pep.master.CompanyMaster.domain.CompanyMaster;
import com.ponsun.pep.master.CompanyMaster.domain.CompanyMasterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyMasterReadPlatformServiceImpl implements CompanyMasterReadPlatformService {
    private final CompanyMasterRepositoryWrapperMaster companyMasterRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyMasterRepository companyMasterRepository;

    @Override
    public CompanyMaster fetchCompanyMasterById(Integer id){

        return this.companyMasterRepository.findById(id).get();

    }
    @Override
    public List<CompanyMaster> fetchAllCompanyMaster(){
        return this.companyMasterRepository.findAll();
    }

}
