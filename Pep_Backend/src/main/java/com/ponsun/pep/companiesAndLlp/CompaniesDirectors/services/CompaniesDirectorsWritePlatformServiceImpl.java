package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompaniesDirectorsDTO;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.data.CompaniesDirectorsDataValidator;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectors;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectorsRepository;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectorsRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.CreatCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.UpdateCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.rowmapper.CompaniesDirectorsRowMapper;
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
public class CompaniesDirectorsWritePlatformServiceImpl implements CompaniesDirectorsWritePlatformService {
    private final CompaniesDirectorsRepository companiesDirectorsRepository;
    private final CompaniesDirectorsRepositoryWrapper companiesDirectorsRepositoryWrapper;
    private final CompaniesDirectorsDataValidator companiesDirectorsDataValidator;
    private final CompaniesDirectorsRowMapper companiesDirectorsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createCompaniesDirectors(CreatCompaniesDirectorsRequest createCompaniesDirectorsRequest) {
        try {
            this.companiesDirectorsDataValidator.validateSaveCompaniesDirectorsData(createCompaniesDirectorsRequest);
            final CompaniesDirectors companiesDirectors = CompaniesDirectors.create(createCompaniesDirectorsRequest);
            this.companiesDirectorsRepository.saveAndFlush(companiesDirectors);
            return Response.of(Long.valueOf(companiesDirectors.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateCompaniesDirectors(Integer id, UpdateCompaniesDirectorsRequest updateCompaniesDirectorsRequest) {
        try {
            this.companiesDirectorsDataValidator.validateUpdateCompaniesDirectorsData(updateCompaniesDirectorsRequest);
            final CompaniesDirectors companiesDirectors = this.companiesDirectorsRepositoryWrapper.findOneWithNotFoundDetection(id);
            companiesDirectors.update(updateCompaniesDirectorsRequest);
            this.companiesDirectorsRepository.saveAndFlush(companiesDirectors);
            return Response.of(Long.valueOf(companiesDirectors.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deActive(Integer companyId, Integer euid){
        try{
            List<CompaniesDirectors> companiesDirectors = this.companiesDirectorsRepositoryWrapper.findOnePepIdWithNotFoundDetection(companyId);
            Response response = null;
            for (CompaniesDirectors directors : companiesDirectors) {
                directors.setEuid(euid);
                directors.setStatus(Status.DELETE);
                directors.setUpdatedAt(LocalDateTime.now());
                this.companiesDirectorsRepository.save(directors);
                response = Response.of(directors.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockCompaniesDirectors(Integer id){
        try{
            final CompaniesDirectors companiesDirectors = this.companiesDirectorsRepositoryWrapper.findOneWithNotFoundDetection(id);
            companiesDirectors.setStatus(Status.DELETE);
            companiesDirectors.setUpdatedAt(LocalDateTime.now());
            this.companiesDirectorsRepository.saveAndFlush(companiesDirectors);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockCompaniesDirectors(Integer id){
        try{
            final CompaniesDirectors companiesDirectors = this.companiesDirectorsRepositoryWrapper.findOneWithNotFoundDetection(id);
            companiesDirectors.setStatus(Status.ACTIVE);
            companiesDirectors.setUpdatedAt(LocalDateTime.now());
            this.companiesDirectorsRepository.saveAndFlush(companiesDirectors);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    public List<CompaniesDirectorsDTO> fetchAllCompaniesDirectorsData(Integer companyId) {
        final CompaniesDirectorsRowMapper rowMapper = new CompaniesDirectorsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.directorId=b.id AND c.id= a.designationId AND a.companyMasterId= d.id AND d.id=a.companyMasterId AND a.STATUS = 'A' AND b.STATUS = 'A' AND a.companyId = "+companyId;
        Qry = Qry + whereClause;
        final List<CompaniesDirectorsDTO> companiesDirectorsDTOList  = jdbcTemplate.query(Qry,companiesDirectorsRowMapper,
                new Object[] {}
        );
        return companiesDirectorsDTOList;
    }
}

