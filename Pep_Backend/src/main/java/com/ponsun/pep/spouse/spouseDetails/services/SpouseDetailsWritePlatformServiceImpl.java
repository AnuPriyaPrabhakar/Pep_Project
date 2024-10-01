package com.ponsun.pep.spouse.spouseDetails.services;


import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseDetailsDTO;
import com.ponsun.pep.spouse.spouseDetails.data.SpouseDetailsDataValidator;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetails;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetailsRepository;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetailsRepositoryWrapper;
import com.ponsun.pep.spouse.spouseDetails.request.CreateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.request.UpdateSpouseDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.spouseDetails.rowmapper.SpouseDetailsRowMapper;
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
public class SpouseDetailsWritePlatformServiceImpl implements  SpouseDetailsWritePlatformService{

    private final SpouseDetailsRepository spouseDetailsRepository;
    private final SpouseDetailsRepositoryWrapper spouseDetailsRepositoryWrapper;
    private final SpouseDetailsDataValidator spouseDetailsDataValidator;
    private final SpouseDetailsRowMapper spouseDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createSpouseDetails(CreateSpouseDetailsRequest createSpouseDetailsRequest) {
        try {
            this.spouseDetailsDataValidator.validateSaveSpouseDetails(createSpouseDetailsRequest);
            final SpouseDetails spouseDetails = SpouseDetails.create(createSpouseDetailsRequest);//entity
            this.spouseDetailsRepository.saveAndFlush(spouseDetails);
            return Response.of(Long.valueOf(spouseDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateSpouseDetails(Integer id, UpdateSpouseDetailsRequest updateSpouseDetailsRequest) {
        try {
            this.spouseDetailsDataValidator.validateUpdateSpouseDetails(updateSpouseDetailsRequest);
            final SpouseDetails spouseDetails = this.spouseDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseDetails.update(updateSpouseDetailsRequest);
            this.spouseDetailsRepository.saveAndFlush(spouseDetails);
            return Response.of(Long.valueOf(spouseDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<SpouseDetailsDTO> fetchSpouseDetailsData(Integer pepId) {
        final SpouseDetailsRowMapper rowMapper = new SpouseDetailsRowMapper();
        String query = "SELECT " + rowMapper.tableSchema() +
                " WHERE pr.pepId = ? AND pr.STATUS = 'A'";
        final List<SpouseDetailsDTO> spouseDetailsDTOS = jdbcTemplate.query(
                query,
                new Object[] { pepId },
                spouseDetailsRowMapper
        );
        return spouseDetailsDTOS;
    }



    @Override
    public Response DeActiveSpouse(Integer pepId, Integer euid){
        try {

            Response response = null;
            updateEntity(pepId,euid);
            updateSpouseHuf(pepId ,euid);
            updateSpouseFather(pepId,euid);
            updateSpouseMother(pepId,euid);
            return response;

        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    public void updateEntity(Integer pepId,Integer euid) {
        String sql = "UPDATE pep_spouse  SET STATUS='D',euid= ?,updated_at=now() WHERE pepId= ?";
        jdbcTemplate.update(sql, euid, pepId);
    }

    private Integer getSpouseId(Integer pepId) {
        String selectQuery = "SELECT id FROM pep_spouse WHERE pepId=? LIMIT 1";
        return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, pepId);
    }

    public void updateSpouseHuf(Integer pepId, Integer euid) {
        //Integer spouseId = getSpouseId(pepId);
        String updateQuery = "UPDATE pep_spouse_huf SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }

    public void updateSpouseFather(Integer pepId, Integer euid) {
        //Integer spouseId = getSpouseId(pepId);
        String str = "UPDATE pep_spouse_father SET STATUS='D', euid=?, updated_at=now() WHERE pepId=?";
        this.jdbcTemplate.update(str, euid, pepId);
    }

    public void updateSpouseMother(Integer pepId, Integer euid) {
        //Integer spouseId = getSpouseId(pepId);
        String str = "UPDATE pep_spouse_mother SET STATUS='D', euid=?, updated_at=now() WHERE pepId=?";
        this.jdbcTemplate.update(str, euid, pepId);
    }

}
