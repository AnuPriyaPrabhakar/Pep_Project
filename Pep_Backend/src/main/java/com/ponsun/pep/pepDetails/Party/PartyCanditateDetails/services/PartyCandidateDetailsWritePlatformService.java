package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCandidateDetailsDTO;

import java.util.List;

public interface PartyCandidateDetailsWritePlatformService {
    Response createParty(CreatePartyCandidateDetailsRequest createPartyRequest);
    List<PartyCandidateDetailsDTO> fetchPartyCandidateDetailsDTO(Integer pepId);
    Response DeActiveParty(Integer pepId, Integer euid);
}
