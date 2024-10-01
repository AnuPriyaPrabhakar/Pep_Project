package com.ponsun.pep.pepDetails.Party.PartyDetails.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;

import com.ponsun.pep.pepDetails.Party.PartyDetails.request.CreatePartyDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.UpdatePartyDetailsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PartyDetailsValidator {
    public void validateSavePartyDetails(final CreatePartyDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdatePartyDetails(final UpdatePartyDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }

}
