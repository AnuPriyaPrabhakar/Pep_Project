package com.ponsun.pep.master.CompanyMaster.service;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.master.CompanyMaster.domain.CompanyMasterRepositoryWrapperMaster;
import com.ponsun.pep.master.CompanyMaster.request.CreateCompanyMasterRequest;
import com.ponsun.pep.master.CompanyMaster.request.UpdateCompanyMasterRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.CompanyMaster.data.CompanyMasterDataValidator;
import com.ponsun.pep.master.CompanyMaster.domain.CompanyMaster;
import com.ponsun.pep.master.CompanyMaster.domain.CompanyMasterRepository;
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
public class CompanyMasterWritePlatformServiceImpl implements CompanyMasterWritePlatformService {
    private final CompanyMasterRepository companyMasterRepository;
    private final CompanyMasterRepositoryWrapperMaster companyMasterRepositoryWrapper;
    private final CompanyMasterDataValidator companyMasterDataValidator;
    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public Response createCompanyMaster(CreateCompanyMasterRequest createCompanyMasterRequest) {
        try {
            this.companyMasterDataValidator.validateSaveCompany(createCompanyMasterRequest);
            final CompanyMaster companyMaster = CompanyMaster.create(createCompanyMasterRequest);
            this.companyMasterRepository.saveAndFlush(companyMaster);
            return Response.of(Long.valueOf(companyMaster.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCompanyMaster(Integer id, UpdateCompanyMasterRequest updateCompanyMasterRequest) {
        try {
            this.companyMasterDataValidator.validateUpdateCompany(updateCompanyMasterRequest);
            final CompanyMaster companyMaster = this.companyMasterRepositoryWrapper.findOneWithNotFoundDetection(id);
            companyMaster.update(updateCompanyMasterRequest);
            this.companyMasterRepository.saveAndFlush(companyMaster);
            return Response.of(Long.valueOf(companyMaster.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
