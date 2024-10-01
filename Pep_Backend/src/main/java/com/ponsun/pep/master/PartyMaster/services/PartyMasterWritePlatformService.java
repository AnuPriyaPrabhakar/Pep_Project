package com.ponsun.pep.master.PartyMaster.services;

import com.ponsun.pep.master.PartyMaster.request.CreatePartyMasterRequest;
import com.ponsun.pep.master.PartyMaster.request.UpdatePartyMasterRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface PartyMasterWritePlatformService {
    Response createPartyMaster(CreatePartyMasterRequest createPartyMasterRequest);

    Response updateParty(Integer id, UpdatePartyMasterRequest updatePartyMasterRequest);

    Response blockPartyMaster(Integer id);

    Response unblockPartyMaster(Integer id);
}
