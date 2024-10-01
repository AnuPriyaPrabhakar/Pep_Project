package com.ponsun.pep.pepDetails.OtherAssociation.data;

import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.request.UpdateOtherAssociationRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OtherAssociationDataValidator {
    public void validateSaveOtherAssociationData(final CreateOtherAssociationRequest request){
        if(request.getPepId() == null || request.getPepId().equals(" ")){
            throw new EQAS_PEP_AppicationException("PepId parameter required");
        }
    }
    public void validateUpdateOtherAssociationData(final UpdateOtherAssociationRequest request){
        if(request.getPepId() == null || request.getPepId().equals("")){
            throw new EQAS_PEP_AppicationException("PepId parameter required");
        }
    }
}
