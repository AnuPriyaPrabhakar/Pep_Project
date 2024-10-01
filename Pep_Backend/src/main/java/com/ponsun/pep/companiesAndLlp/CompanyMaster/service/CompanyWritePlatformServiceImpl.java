package com.ponsun.pep.companiesAndLlp.CompanyMaster.service;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.CompanyRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.CreateCompanyRequest;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.UpdateCompanyRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.data.CompanyDataValitor;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.Company;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyWritePlatformServiceImpl implements CompanyWritePlatformService{
    private final CompanyRepository companyRepository;
    private final CompanyRepositoryWrapper companyRepositoryWrapper;
    private final CompanyDataValitor companyDataValitor;
    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public Response createCompany(CreateCompanyRequest createCompanyRequest) {
        try {
            this.companyDataValitor.validateSaveCompany(createCompanyRequest);
            final Company company = Company.create(createCompanyRequest);
            this.companyRepository.saveAndFlush(company);
            return Response.of(Long.valueOf(company.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCompany(Integer id, UpdateCompanyRequest updateCompanyRequest) {
        try {
            this.companyDataValitor.validateUpdateCompany(updateCompanyRequest);
            final Company company = this.companyRepositoryWrapper.findOneWithNotFoundDetection(id);
            company.update(updateCompanyRequest);
            this.companyRepository.saveAndFlush(company);
            return Response.of(Long.valueOf(company.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public  Response blockCompany(Integer id){
        try {
            final Company company = this.companyRepositoryWrapper.findOneWithNotFoundDetection(id);
            company.setStatus(Status.DELETE);
            company.setUpdatedAt(LocalDateTime.now());
            this.companyRepository.saveAndFlush(company);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockCompany(Integer id){
        try {
            final Company company = this.companyRepositoryWrapper.findOneWithNotFoundDetection(id);
            company.setStatus(Status.ACTIVE);
            company.setUpdatedAt(LocalDateTime.now());
            this.companyRepository.saveAndFlush(company);
            return Response.of(Long.valueOf(id));
        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Integer insertCompany(String companyName, CreateCompanyRequest companyRequest) {
        Integer id = 0;
        try {
            String selectQuery = "SELECT id FROM pep_master WHERE NAME = '"+companyName+"' LIMIT 1";
            List strLst = jdbcTemplate.query(selectQuery, new RowMapper() {
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getString("id");
                }
            });
            if (strLst.isEmpty()) {
                id=0;
            } else if (strLst.size() == 1) {
                id= Integer.parseInt(strLst.get(0).toString());
            }
        } catch (EQAS_PEP_AppicationException ex) {
            id = -1;
        }
        if (id <= 0) {
            final Company company = Company.create(companyRequest);
            Company response = this.companyRepository.saveAndFlush(company);
            id = response.getId();
        }
        return id;
    }

}
