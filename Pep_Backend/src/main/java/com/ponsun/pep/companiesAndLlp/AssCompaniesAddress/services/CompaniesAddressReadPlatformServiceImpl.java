package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddress;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepository;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompaniesAddressReadPlatformServiceImpl implements CompaniesAddressReadPlatformService {
    private final CompaniesAddressRepositoryWrapper companiesAddressRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompaniesAddressRepository companiesAddressRepository;
    @Override
    public CompaniesAddress fetchCompaniesAddressById(Integer id){
        return this.companiesAddressRepository.findById(id).get();
    }
    @Override
    public List<CompaniesAddress> fetchAllCompaniesAddress(){ return this.companiesAddressRepository.findAll();}
}
