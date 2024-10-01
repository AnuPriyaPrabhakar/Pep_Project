package com.ponsun.pep.RequestDescription.data;

import com.ponsun.pep.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.pep.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestDescriptionDataValidator {
    public void validateSaveRequestDescription(final CreateRequestDescriptionRequest request){
        if(request.getDescription() == null || request.getDescription().equals("")){
            throw new EQAS_PEP_AppicationException("description parameter required");
        }
    }
    public void validateUpdateRequestDescription(final UpdateRequestDescriptionRequest request){
        if(request.getDescription() == null || request.getDescription().equals("")){
            throw new EQAS_PEP_AppicationException("description parameter required");
        }
    }
}
