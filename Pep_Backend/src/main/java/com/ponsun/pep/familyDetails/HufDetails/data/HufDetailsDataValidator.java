package com.ponsun.pep.familyDetails.HufDetails.data;

import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.request.UpdateHufDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HufDetailsDataValidator {

    public void validateSaveHufDetails(final CreateHufDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateHufDetails(final UpdateHufDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
