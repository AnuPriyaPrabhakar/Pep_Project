package com.ponsun.pep.companiesAndLlp.CompanyDocuments.services;

import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocuments;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocumentsRepository;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocumentsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyDocumentsReadPlatformServiceImpl implements  CompanyDocumentsReadPlatformService{

    private final CompanyDocumentsRepositoryWrapper companyDocumentsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyDocumentsRepository companyDocumentsRepository;


    @Override
    public List<CompanyDocuments> fetchAllCompanyDocuments() {
        return this.companyDocumentsRepository.findAll();
    }

    @Override
    public CompanyDocuments fetchCompanyDocumentsById(Integer id) {
        return this.companyDocumentsRepository.findById(id).get();
    }
}
