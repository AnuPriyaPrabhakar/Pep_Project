package com.ponsun.pep.familyDetails.HufDetails.services;


import com.ponsun.pep.familyDetails.FamilyCommonService.dto.HufDTO;
import com.ponsun.pep.familyDetails.HufDetails.data.HufDetailsDataValidator;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetails;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetailsRepository;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetailsRepositoryWrapper;
import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.request.UpdateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.rowmapper.HufDetailsRowMapper;
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
public class HufDetailsWritePlatFormServiceImpl implements  HufDetailsWritePlatFormService{

    private final HufDetailsRepository hufDetailsRepository;
    private final HufDetailsRepositoryWrapper hufDetailsRepositoryWrapper;
    private final HufDetailsDataValidator hufDetailsDataValidator;
    private final HufDetailsRowMapper hufDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createHufDetails(CreateHufDetailsRequest createHufDetailsRequest) {
        try {
            this.hufDetailsDataValidator.validateSaveHufDetails(createHufDetailsRequest);
            final HufDetails hufDetails = HufDetails.create(createHufDetailsRequest);//entity
            this.hufDetailsRepository.saveAndFlush(hufDetails);
            return Response.of(Long.valueOf(hufDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateHufDetailsList(Integer id, UpdateHufDetailsRequest updateHufDetailsRequest) {
        try {
            this.hufDetailsDataValidator.validateUpdateHufDetails(updateHufDetailsRequest);
            final HufDetails hufDetails = this.hufDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            hufDetails.update(updateHufDetailsRequest);
            this.hufDetailsRepository.saveAndFlush(hufDetails);
            return Response.of(Long.valueOf(hufDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<HufDTO> fetchHufDTO(Integer pepId) {
        final HufDetailsRowMapper rowMapper = new HufDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ph.pepId = ?  AND ph.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<HufDTO> hufDTOS  = jdbcTemplate.query(Qry,hufDetailsRowMapper,
                new Object[] {pepId}
        );
        return hufDTOS;
    }

    public void updateHuf(Integer pepId, Integer euid) {
        String updateQuery = "UPDATE pep_huf SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        System.out.println("Update Query: " + updateQuery); // Print the query
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }
}
