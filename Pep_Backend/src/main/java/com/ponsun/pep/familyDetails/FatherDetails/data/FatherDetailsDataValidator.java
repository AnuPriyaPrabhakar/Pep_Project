package com.ponsun.pep.familyDetails.FatherDetails.data;


import com.ponsun.pep.familyDetails.FatherDetails.request.CreateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.request.UpdateFatherDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FatherDetailsDataValidator {
    public void validateSaveFatherDetails(final CreateFatherDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateFatherDetails(final UpdateFatherDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
