package com.ponsun.pep.spouse.spouseDetails.data;

import com.ponsun.pep.spouse.spouseDetails.request.CreateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.request.UpdateSpouseDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpouseDetailsDataValidator {
    public void validateSaveSpouseDetails(final CreateSpouseDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateSpouseDetails(final UpdateSpouseDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
