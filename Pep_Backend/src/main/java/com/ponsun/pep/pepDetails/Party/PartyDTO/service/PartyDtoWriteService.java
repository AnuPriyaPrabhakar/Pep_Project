package com.ponsun.pep.pepDetails.Party.PartyDTO.service;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;

import java.util.List;

public interface PartyDtoWriteService {
    Response createPartyDetails(Integer pepId, List<PartyCommonDto> partyCommonDto);
    Response createAndUpdatePartyDetails(Integer pepId, Integer euid, List<PartyCommonDto> partyCommonDto);
}
