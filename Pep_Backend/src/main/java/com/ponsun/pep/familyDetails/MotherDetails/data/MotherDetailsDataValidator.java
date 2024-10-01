package com.ponsun.pep.familyDetails.MotherDetails.data;

import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.request.UpdateHufDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.request.CreateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.request.UpdateMotherDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MotherDetailsDataValidator {
    public void validateSaveMotherDetails(final CreateMotherDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateMotherDetails(final UpdateMotherDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
