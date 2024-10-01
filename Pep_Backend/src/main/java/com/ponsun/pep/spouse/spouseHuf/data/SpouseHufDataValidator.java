package com.ponsun.pep.spouse.spouseHuf.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.spouse.spouseHuf.request.CreateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseHuf.request.UpdateSpouseHufRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpouseHufDataValidator {
    public void validateSaveSpouseHuf(final CreateSpouseHufRequest request){
        if (request.getHufName()== null || request.getHufName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateSpouseHuf(final UpdateSpouseHufRequest request){
        if(request.getHufName() == null || request.getHufName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");


        }
    }
}
