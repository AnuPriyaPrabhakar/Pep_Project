package com.ponsun.pep.relativeDetails.Relativedet.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.request.UpdateRelativeDetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RelativeDetDataValidator {
    public void validateSaveRelativeDet (final CreateRelativeDetRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateRelativeDet (final UpdateRelativeDetRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
