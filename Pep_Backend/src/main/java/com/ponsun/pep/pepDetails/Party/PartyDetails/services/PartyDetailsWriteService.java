package com.ponsun.pep.pepDetails.Party.PartyDetails.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDetails.data.PartyDetailsData;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.CreatePartyDetailsRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PartyDetailsWriteService {

    Response createPartyDetails(CreatePartyDetailsRequest createPartyDetailsRequest);

    List<PartyDetailsDTO> fetchPartyDetailsDTO(Integer pepId, Integer partyCandidateId);
}
