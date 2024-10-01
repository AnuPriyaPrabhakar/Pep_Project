package com.ponsun.pep.relativeDetails.Relative.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.request.UpdateRelativeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RelativeDataValidator {
    public void validateSaveRelative (final CreateRelativeRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateRelative (final UpdateRelativeRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");


        }
    }}