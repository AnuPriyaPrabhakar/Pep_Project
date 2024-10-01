package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services;

import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssociatedCompaniesReadPlatformServiceImpl implements AssociatedCompaniesReadPlatformService {
    private final AssociatedCompaniesRepositoryWrapper associatedCompaniesRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AssociatedCompaniesRepository associatedCompaniesRepository;
    @Override
    public AssociatedCompanies fetchAssociatedCompaniesById(Integer id){
        return this.associatedCompaniesRepository.findById(id).get();
    }
    @Override
    public List<AssociatedCompanies> fetchAllAssociatedCompanies(){ return this.associatedCompaniesRepository.findAll();}


}
