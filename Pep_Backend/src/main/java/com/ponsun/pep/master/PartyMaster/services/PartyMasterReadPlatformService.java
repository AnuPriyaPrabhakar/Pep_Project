package com.ponsun.pep.master.PartyMaster.services;

import com.ponsun.pep.master.PartyMaster.domain.PartyMaster;

import java.util.List;

public interface PartyMasterReadPlatformService {
    List<PartyMaster> fetchAllParty();

    PartyMaster fetchPartyMasterById(Integer id);
}
