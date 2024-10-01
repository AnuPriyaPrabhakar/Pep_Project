package com.ponsun.pep.dinEdit.data;

import com.ponsun.pep.dinEdit.request.CreateDinEditRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DinEditDataValidator {
    public void validateSaveDinEdit(final CreateDinEditRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("Name parameter required");
        }
    }
}
