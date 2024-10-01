package com.ponsun.pep.spouse.spouseFather.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.spouse.spouseFather.request.CreateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.request.UpdateSpouseFatherRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpouseFatherDataValidator {
    public void validateSaveSpouseFather(final CreateSpouseFatherRequest request){
        if (request.getFatherName()== null || request.getFatherName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateSpouseFather(final UpdateSpouseFatherRequest request){
        if(request.getFatherName() == null || request.getFatherName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");


        }
    }
}
