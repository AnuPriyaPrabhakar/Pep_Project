package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services;

import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDet;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssCompanyContactDetReadPlatformServiceImpl implements AssCompanyContactDetReadPlatformService {

    private final AssCompanyContactDetRepositoryWrapper assCompanyContactDetRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AssCompanyContactDetRepository assCompanyContactDetRepository;

    @Override
    public AssCompanyContactDet fetchCompanyContactDetById(Integer id){
        return this.assCompanyContactDetRepository.findById(id).get();
    }
    @Override
    public List<AssCompanyContactDet> fetchAllCompanyContactDet(){
        return this.assCompanyContactDetRepository.findAll();
    }
}
