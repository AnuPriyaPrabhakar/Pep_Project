package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services;


import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsValidator;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetails;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsWrapperCandidateDetails;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.rowmapper.PartyCandidateDetailsRowMapper;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCandidateDetailsDTO;
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
public class PartyCandidateDetailsWritePlatformServiceImpl implements PartyCandidateDetailsWritePlatformService {

    private final PartyCandidateDetailsRepository partyCandidateDetailsRepository;
    private final PartyCandidateDetailsWrapperCandidateDetails partyCandidateDetailsWrapper;
    private final PartyCandidateDetailsValidator partyCandidateDetailsValidator;
    private final JdbcTemplate jdbcTemplate;
    private final PartyCandidateDetailsRowMapper partyCandidateDetailsRowMapper;
    @Override
    @Transactional
    public Response createParty(CreatePartyCandidateDetailsRequest createPartyRequest) {
        try {
            this.partyCandidateDetailsValidator.validateSaveParty(createPartyRequest);
            final PartyCandidateDetails partyCandidateDetails = PartyCandidateDetails.create(createPartyRequest);
            this.partyCandidateDetailsRepository.saveAndFlush(partyCandidateDetails);
            return Response.of(Long.valueOf(partyCandidateDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<PartyCandidateDetailsDTO> fetchPartyCandidateDetailsDTO(Integer pepId) {
        final PartyCandidateDetailsRowMapper rowMapper = new PartyCandidateDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE pcd.pepId = ?  AND pcd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<PartyCandidateDetailsDTO> partyCandidateDetailsDTOS  = jdbcTemplate.query(Qry,partyCandidateDetailsRowMapper,
                new Object[] {pepId}
        );

        return partyCandidateDetailsDTOS;
    }


    @Override
    @Transactional

    public Response DeActiveParty(Integer pepId, Integer euid){
        try {

            Response response = null;
            updatePartyCandidate(pepId,euid);
            updateParty(pepId ,euid);
            return response;

        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    public void updatePartyCandidate(Integer pepId,Integer euid) {
        String sql = "UPDATE pep_party_candidate_details  SET STATUS='D',euid= ?,updated_at=now() WHERE pepId= ?";
        jdbcTemplate.update(sql, euid, pepId);
    }
    public void updateParty(Integer pepId, Integer euid) {
        String updateQuery = "UPDATE pep_party_details SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }



}


