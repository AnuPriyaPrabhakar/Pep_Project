package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.UpdatePartyCandidateDetailsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PartyCandidateDetailsValidator {
    public void validateSaveParty(final CreatePartyCandidateDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateParty(final UpdatePartyCandidateDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }

}
