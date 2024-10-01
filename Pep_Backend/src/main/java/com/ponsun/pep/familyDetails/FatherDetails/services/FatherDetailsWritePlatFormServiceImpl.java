package com.ponsun.pep.familyDetails.FatherDetails.services;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FatherDTO;
import com.ponsun.pep.familyDetails.FatherDetails.data.FatherDetailsDataValidator;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetails;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetailsRepository;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetailsRepositoryWrapper;
import com.ponsun.pep.familyDetails.FatherDetails.request.CreateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.request.UpdateFatherDetailsRequest;

import com.ponsun.pep.familyDetails.FatherDetails.rowmapper.FatherDetailsRowMapper;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FatherDetailsWritePlatFormServiceImpl  implements FatherDetailsWritePlatFormService{
    private final FatherDetailsRepository fatherDetailsRepository;
    private final FatherDetailsRepositoryWrapper fatherDetailsRepositoryWrapper;
    private final FatherDetailsDataValidator fatherDetailsDataValidator;
    private final FatherDetailsRowMapper fatherDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createFatherDetails(CreateFatherDetailsRequest createFatherDetailsRequest) {
        try {
            this.fatherDetailsDataValidator.validateSaveFatherDetails(createFatherDetailsRequest);
            final FatherDetails fatherDetails = FatherDetails.create(createFatherDetailsRequest);//entity
            this.fatherDetailsRepository.saveAndFlush(fatherDetails);
            return Response.of(Long.valueOf(fatherDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateFatherDetailsList(Integer id, UpdateFatherDetailsRequest updateFatherDetailsRequest) {
        try {
            this.fatherDetailsDataValidator.validateUpdateFatherDetails(updateFatherDetailsRequest);
            final FatherDetails fatherDetails = this.fatherDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            fatherDetails.update(updateFatherDetailsRequest);
            this.fatherDetailsRepository.saveAndFlush(fatherDetails);
            return Response.of(Long.valueOf(fatherDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<FatherDTO> fetchFatherDTO(Integer pepId) {
        final FatherDetailsRowMapper rowMapper = new FatherDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE father.pepId = ?  AND father.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<FatherDTO> fatherDTOS  = jdbcTemplate.query(Qry,fatherDetailsRowMapper,
                new Object[] {pepId}
        );
        return fatherDTOS;
    }
    @Override
    public Response DeActiveFamily(Integer pepId, Integer euid){
        try {

            Response response = null;
            updateHuf(pepId,euid);
            updateMother(pepId ,euid);
            updateFather(pepId,euid);
            return response;

        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    public void updateHuf(Integer pepId, Integer euid) {
        String updateQuery = "UPDATE pep_huf SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }
    public void updateMother(Integer pepId, Integer euid) {
        String updateQuery = "UPDATE pep_mother SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }
    public void updateFather(Integer pepId, Integer euid) {
        String updateQuery = "UPDATE pep_father SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }
}
