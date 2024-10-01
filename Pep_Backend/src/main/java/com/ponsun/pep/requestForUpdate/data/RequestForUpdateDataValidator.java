package com.ponsun.pep.requestForUpdate.data;

import com.ponsun.pep.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.pep.requestForUpdate.request.UpdateRequestForUpdateRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestForUpdateDataValidator {
    public void validateSaveRequestForUpdate (final CreateRequestForUpdateRequest request) {
        if (request.getRequestForUpdate() == null || request.getRequestForUpdate().equals("")) {
            throw new EQAS_PEP_AppicationException("RequestForUpdate parameter required");
        }
    }
    public void validateUpdateRequestForUpdate (final UpdateRequestForUpdateRequest request) {
        if (request.getRequestForUpdate() == null || request.getRequestForUpdate().equals("")) {
            throw new EQAS_PEP_AppicationException("RequestForUpdate parameter required");
        }
    }
}
