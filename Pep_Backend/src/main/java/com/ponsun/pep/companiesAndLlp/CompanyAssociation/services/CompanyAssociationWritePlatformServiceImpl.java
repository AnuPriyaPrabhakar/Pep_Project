package com.ponsun.pep.companiesAndLlp.CompanyAssociation.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAssociationDTO;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.data.CompanyAssociationDataValidator;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociation;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociationRepository;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociationRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.CreateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.UpdateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.rowmapper.CompanyAssociationRowMapper;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyAssociationWritePlatformServiceImpl implements CompanyAssociationWritePlatformService {
    private final CompanyAssociationRepository companyAssociationRepository;
    private final CompanyAssociationRepositoryWrapper companyAssociationRepositoryWrapper;
    private final CompanyAssociationDataValidator companyAssociationDataValidator;
    private final CompanyAssociationRowMapper companyAssociationRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public Response createCompanyAssociation(CreateCompanyAssociationRequest createCompanyAssociationRequest){
        try {
            this.companyAssociationDataValidator.validateSaveCompanyAssociationData(createCompanyAssociationRequest);
            final CompanyAssociation companyAssociation = CompanyAssociation.create(createCompanyAssociationRequest);
            this.companyAssociationRepository.saveAndFlush(companyAssociation);
            return Response.of(Long.valueOf(companyAssociation.getId()));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateCompanyAssociation(Integer id, UpdateCompanyAssociationRequest updateCompanyAssociationRequest) {
        try {
            this.companyAssociationDataValidator.validateUpdateCompanyAssociationData(updateCompanyAssociationRequest);
            final CompanyAssociation CompanyAssociation = this.companyAssociationRepositoryWrapper.findOneWithNotFoundDetection(id);
            CompanyAssociation.update(updateCompanyAssociationRequest);
            this.companyAssociationRepository.saveAndFlush(CompanyAssociation);
            return Response.of(Long.valueOf(CompanyAssociation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deActive(Integer companyId, Integer euid){
        try{
            List<CompanyAssociation> companyAssociations = this.companyAssociationRepositoryWrapper.findOneCompanyWithNotFoundDetection(companyId);
            Response response = null;
            for (CompanyAssociation companyAssociation : companyAssociations) {
                companyAssociation.setEuid(euid);
                companyAssociation.setStatus(Status.DELETE);
                companyAssociation.setUpdatedAt(LocalDateTime.now());
                this.companyAssociationRepository.save(companyAssociation);
                response = Response.of(companyAssociation.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockCompanyAssociation(Integer id){
        try{
            final CompanyAssociation CompanyAssociation = this.companyAssociationRepositoryWrapper.findOneWithNotFoundDetection(id);
            CompanyAssociation.setStatus(Status.DELETE);
            CompanyAssociation.setUpdatedAt(LocalDateTime.now());
            this.companyAssociationRepository.saveAndFlush(CompanyAssociation);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockCompanyAssociation(Integer id){
        try {
            final CompanyAssociation CompanyAssociation = this.companyAssociationRepositoryWrapper.findOneWithNotFoundDetection(id);
            CompanyAssociation.setStatus(Status.ACTIVE);
            CompanyAssociation.setUpdatedAt(LocalDateTime.now());
            this.companyAssociationRepository.saveAndFlush(CompanyAssociation);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CompanyAssociationDTO> fetchAllAsCompanyAssociationData(Integer companyId) {
        final CompanyAssociationRowMapper rowMapper = new CompanyAssociationRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE coa.companyId = ? AND coa.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CompanyAssociationDTO> companyAssociationDTOS  = jdbcTemplate.query(Qry,companyAssociationRowMapper,
                new Object[] {companyId}
        );
        return companyAssociationDTOS;
    }
}
