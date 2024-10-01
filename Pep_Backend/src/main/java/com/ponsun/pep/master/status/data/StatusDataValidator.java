package com.ponsun.pep.master.status.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.master.status.request.CreateStatusRequest;
import com.ponsun.pep.master.status.request.UpdateStatusRequest;

public class StatusDataValidator {

    public void validateSaveModuleDet(final CreateStatusRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateStatusRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
}
