package com.ponsun.pep.companiesAndLlp.CompanyAssociation.services;

import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociation;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociationRepository;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociationRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyAssociationReadPlatformServiceImpl implements CompanyAssociationReadPlatformService {
    private final CompanyAssociationRepositoryWrapper companyAssociationRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyAssociationRepository companyAssociationRepository;
    @Override
    public CompanyAssociation fetchCompanyAssociationById(Integer id){
        return this.companyAssociationRepository.findById(id).get();
    }
    @Override
    public List<CompanyAssociation> fetchAllCompanyAssociation(){ return this.companyAssociationRepository.findAll();}

    @Override
    public List<CompanyAssociation> OtherAssociationFindByPepId(Integer companyId)
    {
        return this.companyAssociationRepository.findByCompanyId(companyId);
    }

}
