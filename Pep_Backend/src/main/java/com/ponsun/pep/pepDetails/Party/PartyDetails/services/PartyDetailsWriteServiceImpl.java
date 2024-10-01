package com.ponsun.pep.pepDetails.Party.PartyDetails.services;



import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDetails.data.PartyDetailsValidator;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetails;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetailsWrapper;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.CreatePartyDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyDetails.rowmapper.PartyDetailsRowMapper;
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
public class PartyDetailsWriteServiceImpl implements  PartyDetailsWriteService {

    private final PartyDetailsRepository partyDetailsRepository;
    private final PartyDetailsWrapper partyDetailsWrapper;
    private final PartyDetailsValidator partyDetailsValidator;
    private final JdbcTemplate jdbcTemplate;
    private final PartyDetailsRowMapper partyDetailsRowMapper;


    @Override
    @Transactional
    public Response createPartyDetails(CreatePartyDetailsRequest createPartyDetailsRequest) {
        try {
            this.partyDetailsValidator.validateSavePartyDetails(createPartyDetailsRequest);
            final PartyDetails partyDetails = PartyDetails.create(createPartyDetailsRequest);
            if (!partyDetails.getFormerAndCurrent().isEmpty()) {
                this.partyDetailsRepository.saveAndFlush(partyDetails);
            }
            return Response.of(Long.valueOf(partyDetails.getId()));
        } catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


    @Override
    public List<PartyDetailsDTO> fetchPartyDetailsDTO(Integer pepId, Integer partyCandidateId) {
        final PartyDetailsRowMapper rowMapper = new PartyDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.pepId = ? AND a.partyCandidateId= ? AND a.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<PartyDetailsDTO> partyDetailsDTOS  = jdbcTemplate.query(Qry,partyDetailsRowMapper,
                new Object[] {pepId,partyCandidateId}
        );

        return partyDetailsDTOS;
    }
}
