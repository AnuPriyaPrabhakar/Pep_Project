package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.data.AssCompanyContactDetDataValidator;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDet;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.CreateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.UpdateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.rowmapper.AssCompanyContactDetRowMapper;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyContactDTO;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssCompanyContactDetWritePlatformServiceImpl implements AssCompanyContactDetWritePlatformService {

    private final AssCompanyContactDetRepository assCompanyContactDetRepository;
    private final AssCompanyContactDetRepositoryWrapper assCompanyContactDetRepositoryWrapper;
    private final AssCompanyContactDetDataValidator assCompanyContactDetDataValidator;
    private final AssCompanyContactDetRowMapper assCompanyContactDetRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createCompanyContactDet(CreateAssCompanyContactDetRequest createAssCompanyContactDetRequest) {
        try {
            this.assCompanyContactDetDataValidator.validateSaveCompanyContactDetData(createAssCompanyContactDetRequest);
            final AssCompanyContactDet assCompanyContactDet = AssCompanyContactDet.create(createAssCompanyContactDetRequest);//entity
            this.assCompanyContactDetRepository.saveAndFlush(assCompanyContactDet);
            return Response.of(Long.valueOf(assCompanyContactDet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCompanyContactDet(Integer id, UpdateAssCompanyContactDetRequest updateAssCompanyContactDetRequest) {
        try {
            this.assCompanyContactDetDataValidator.validateUpdateCompanyContactDetData(updateAssCompanyContactDetRequest);
           final AssCompanyContactDet assCompanyContactDet = this.assCompanyContactDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            assCompanyContactDet.update(updateAssCompanyContactDetRequest);
            this.assCompanyContactDetRepository.saveAndFlush(assCompanyContactDet);
            return Response.of(Long.valueOf(assCompanyContactDet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deactive(Integer companyId, Integer euid){
        try{
            List<AssCompanyContactDet> assCompanyContactDet = this.assCompanyContactDetRepositoryWrapper.findOnePepIdWithNotFoundDetection(companyId);
            Response response = null;
            for (AssCompanyContactDet contactDet : assCompanyContactDet) {
                contactDet.setEuid(euid);
                contactDet.setStatus(Status.DELETE);
                contactDet.setUpdatedAt(LocalDateTime.now());
                this.assCompanyContactDetRepository.save(contactDet);

                response = Response.of(contactDet.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockCompanyContactDet(Integer id) {
        try {
            final AssCompanyContactDet assCompanyContactDet = this.assCompanyContactDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            assCompanyContactDet.setStatus(Status.DELETE);
            assCompanyContactDet.setUpdatedAt(LocalDateTime.now());
            this.assCompanyContactDetRepository.saveAndFlush(assCompanyContactDet);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockCompanyContactDet(Integer id) {
        try {
            final AssCompanyContactDet assCompanyContactDet = this.assCompanyContactDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            assCompanyContactDet.setStatus(Status.ACTIVE);
            assCompanyContactDet.setUpdatedAt(LocalDateTime.now());
            this.assCompanyContactDetRepository.saveAndFlush(assCompanyContactDet);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CompanyContactDTO> fetchAllAssCompanyContactDetData(Integer companyId) {
        final AssCompanyContactDetRowMapper rowMapper = new AssCompanyContactDetRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cd.companyId = ? AND cd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CompanyContactDTO> companyContactDTOS  = jdbcTemplate.query(Qry,assCompanyContactDetRowMapper,
                new Object[] {companyId}
        );
        return companyContactDTOS;
    }
}




