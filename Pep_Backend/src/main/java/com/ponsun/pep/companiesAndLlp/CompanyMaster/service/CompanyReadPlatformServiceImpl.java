package com.ponsun.pep.companiesAndLlp.CompanyMaster.service;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.CompanyRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.Company;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyReadPlatformServiceImpl implements CompanyReadPlatformService {
    private final CompanyRepositoryWrapper companyRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyRepository companyRepository;

    @Override
    public Company fetchCompanyById(Integer id){

        return this.companyRepository.findById(id).get();

    }
    @Override
    public List<Company> fetchAllCompany(){
        return this.companyRepository.findAll();
    }

}
