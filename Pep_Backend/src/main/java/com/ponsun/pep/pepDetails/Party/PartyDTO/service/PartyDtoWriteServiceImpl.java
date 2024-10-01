package com.ponsun.pep.pepDetails.Party.PartyDTO.service;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetails;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services.PartyCandidateDetailsWritePlatformService;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetails;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.CreatePartyDetailsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class    PartyDtoWriteServiceImpl implements PartyDtoWriteService {

    private final PartyDetailsRepository partyDetailsRepository;
    private final PartyCandidateDetailsRepository partyCandidateDetailsRepository;
    private final PartyCandidateDetailsWritePlatformService partyCandidateDetailsWritePlatformService;

    @Override
    @Transactional
    public Response createPartyDetails(Integer pepId, List<PartyCommonDto> partyCommonDto) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            for (PartyCommonDto dto : partyCommonDto) {
                CreatePartyCandidateDetailsRequest request = modelMapper.map(dto.getPartyCandidateDetailsDTO(), CreatePartyCandidateDetailsRequest.class);
                final PartyCandidateDetails partyCandidateDetails = PartyCandidateDetails.create(request);
                {
                    partyCandidateDetails.setPepId(pepId);
                    this.partyCandidateDetailsRepository.save(partyCandidateDetails);
                    int partyCandidateId = partyCandidateDetails.getId();
                    response = Response.of(partyCandidateDetails.getId());

                    for (PartyDetailsDTO partyDetailsDTO : dto.getPartyDetailsDTO()) {
                        CreatePartyDetailsRequest createPartyDetailsRequest = modelMapper.map(partyDetailsDTO, CreatePartyDetailsRequest.class);
                        createPartyDetailsRequest.setPartyCandidateId(partyCandidateId);
                        createPartyDetailsRequest.setPepId(pepId);
                        final PartyDetails partyDetails = PartyDetails.create(createPartyDetailsRequest);
                        this.partyDetailsRepository.save(partyDetails);
                    }
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response createAndUpdatePartyDetails(Integer pepId, Integer euid, List<PartyCommonDto> partyCommonDtos) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            for (PartyCommonDto dto : partyCommonDtos) {
                this.partyCandidateDetailsWritePlatformService.DeActiveParty(pepId, euid);
                CreatePartyCandidateDetailsRequest request = modelMapper.map(dto.getPartyCandidateDetailsDTO(), CreatePartyCandidateDetailsRequest.class);
                final PartyCandidateDetails partyCandidateDetails = PartyCandidateDetails.create(request);
                {
                    partyCandidateDetails.setPepId(pepId);
                    this.partyCandidateDetailsRepository.save(partyCandidateDetails);
                    int partyCandidateId = partyCandidateDetails.getId();
                    response = Response.of(partyCandidateDetails.getId());

                    for (PartyDetailsDTO partyDetailsDTO : dto.getPartyDetailsDTO()) {
                        CreatePartyDetailsRequest createPartyDetailsRequest = modelMapper.map(partyDetailsDTO, CreatePartyDetailsRequest.class);
                        createPartyDetailsRequest.setPartyCandidateId(partyCandidateId);
                        createPartyDetailsRequest.setPepId(pepId);
                        final PartyDetails partyDetails = PartyDetails.create(createPartyDetailsRequest);
                        this.partyDetailsRepository.save(partyDetails);
                    }
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
