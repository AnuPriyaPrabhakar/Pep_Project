package com.ponsun.pep.master.PartyMaster.data;

import com.ponsun.pep.master.PartyMaster.request.CreatePartyMasterRequest;
import com.ponsun.pep.master.PartyMaster.request.UpdatePartyMasterRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class PartyMasterDataValidator {
    public void validateSavePartyMaster(final CreatePartyMasterRequest request){
        if(request.getPartyName() == null || request.getPartyName().equals("")){
            throw new EQAS_PEP_AppicationException("StateName parameter required");
        }
    }
    public void validateUpdatePartyMaster(final UpdatePartyMasterRequest request){
        if(request.getPartyName() == null || request.getPartyName().equals("")){
            throw new EQAS_PEP_AppicationException("StateName parameter required");
        }
    }
}
