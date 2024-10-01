package com.ponsun.pep.pepDetails.Party.PartyDTO.service;

import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;

import java.util.List;

public interface PartyDtoReadService {
    List<PartyCommonDto> getPartyDetails(Integer pepId);
}
