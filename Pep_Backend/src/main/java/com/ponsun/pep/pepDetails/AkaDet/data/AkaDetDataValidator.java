package com.ponsun.pep.pepDetails.AkaDet.data;

import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.request.UpdateAkaDetRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AkaDetDataValidator {
    public void validateSaveAkaDet(final CreateAkaDetRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateAkaDet(final UpdateAkaDetRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
}
