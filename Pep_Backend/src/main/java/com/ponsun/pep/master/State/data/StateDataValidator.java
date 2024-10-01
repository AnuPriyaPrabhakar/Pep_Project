package com.ponsun.pep.master.State.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.master.State.request.CreateStateRequest;
import com.ponsun.pep.master.State.request.UpdateStateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StateDataValidator {
    public void validatesaveStateData(final CreateStateRequest request){
        if(request.getStateName() == null || request.getStateName().equals("")){
            throw new EQAS_PEP_AppicationException("StateName parameter required");
        }
    }
    public void validateUpdateStateData(final UpdateStateRequest request){
        if(request.getStateName() == null || request.getStateName().equals("")){
            throw new EQAS_PEP_AppicationException("StateName parameter required");
        }
    }
}
