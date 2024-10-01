package com.ponsun.pep.pepDetails.Party.PartyDetails.services;

import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetails;

import java.util.List;

public interface PartyDetailsReadService {
    PartyDetails fetchPartyDetailsById(Integer id);

    List<PartyDetails> fetchAllPartyDetails();
}
