package com.ponsun.pep.familyDetails.MotherDetails.services;


import com.ponsun.pep.familyDetails.FamilyCommonService.dto.MotherDTO;
import com.ponsun.pep.familyDetails.MotherDetails.data.MotherDetailsDataValidator;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetails;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetailsRepository;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetailsRepositoryWrapper;
import com.ponsun.pep.familyDetails.MotherDetails.request.CreateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.request.UpdateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.rowmapper.MotherDetailsRowMapper;
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
public class MotherDetailsWritePlatformServiceImpl implements  MotherDetailsWritePlatformService{

    private final MotherDetailsRepository motherDetailsRepository;
    private final MotherDetailsRepositoryWrapper motherDetailsRepositoryWrapper;
    private final MotherDetailsDataValidator motherDetailsDataValidator;
    private final MotherDetailsRowMapper motherDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createMotherDetails(CreateMotherDetailsRequest createMotherDetailsRequest) {
        try {
            this.motherDetailsDataValidator.validateSaveMotherDetails(createMotherDetailsRequest);
            final MotherDetails motherDetails = MotherDetails.create(createMotherDetailsRequest);//entity
            this.motherDetailsRepository.saveAndFlush(motherDetails);
            return Response.of(Long.valueOf(motherDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateMotherDetails(Integer id, UpdateMotherDetailsRequest updateMotherDetailsRequest) {
        try {
            this.motherDetailsDataValidator.validateUpdateMotherDetails(updateMotherDetailsRequest);
            final MotherDetails motherDetails = this.motherDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            motherDetails.update(updateMotherDetailsRequest);
            this.motherDetailsRepository.saveAndFlush(motherDetails);
            return Response.of(Long.valueOf(motherDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<MotherDTO> fetchMotherDTO(Integer pepId) {
        final MotherDetailsRowMapper rowMapper = new MotherDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE pm.pepId = ?  AND pm.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<MotherDTO> motherDTOS  = jdbcTemplate.query(Qry,motherDetailsRowMapper,
                new Object[] {pepId}
        );
        return motherDTOS;
    }
}
