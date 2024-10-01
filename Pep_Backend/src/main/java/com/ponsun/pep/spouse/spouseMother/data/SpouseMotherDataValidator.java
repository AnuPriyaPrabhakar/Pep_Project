package com.ponsun.pep.spouse.spouseMother.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.spouse.spouseMother.request.CreateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.request.UpdateSpouseMotherRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpouseMotherDataValidator {
    public void validateSaveSpouseMother(final CreateSpouseMotherRequest request){
        if (request.getMotherName()== null || request.getMotherName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateSpouseMother(final UpdateSpouseMotherRequest request){
        if(request.getMotherName() == null || request.getMotherName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");


        }
    }
}
