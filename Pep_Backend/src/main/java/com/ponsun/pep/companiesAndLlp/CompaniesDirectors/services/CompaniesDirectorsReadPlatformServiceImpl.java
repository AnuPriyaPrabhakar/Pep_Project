package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services;

import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectors;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectorsRepository;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectorsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class CompaniesDirectorsReadPlatformServiceImpl implements CompaniesDirectorsReadPlatformService{
    private final CompaniesDirectorsRepositoryWrapper companiesDirectorsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompaniesDirectorsRepository companiesDirectorsRepository;
    @Override
    public CompaniesDirectors fetchCompaniesDirectorsById(Integer id){
        return this.companiesDirectorsRepository.findById(id).get();
    }
    @Override
    public List<CompaniesDirectors> fetchAllCompaniesAddress(){ return this.companiesDirectorsRepository.findAll();}
}
