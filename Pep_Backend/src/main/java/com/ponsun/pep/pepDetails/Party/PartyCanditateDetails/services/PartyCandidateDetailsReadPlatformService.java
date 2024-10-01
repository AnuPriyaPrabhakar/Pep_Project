package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services;

import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyReadData;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetails;

import java.util.List;

public interface PartyCandidateDetailsReadPlatformService {
    List<PartyCandidateDetails> fetchAllParty();
    PartyCandidateDetails fetchPartyById(Integer id);
    //List<PartyReadData> findByPepId(Integer pepId);
//    Party findByPepId(Integer pepId);
}
