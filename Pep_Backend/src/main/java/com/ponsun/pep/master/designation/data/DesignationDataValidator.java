package com.ponsun.pep.master.designation.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.master.designation.request.CreateDesignationRequest;
import com.ponsun.pep.master.designation.request.UpdateDesignationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DesignationDataValidator {
    public void validateSaveDesignation(final CreateDesignationRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("D parameter required");
        }
    }
    public void validateUpdateDesignation(final UpdateDesignationRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("Department parameter required");
        }
    }
}
