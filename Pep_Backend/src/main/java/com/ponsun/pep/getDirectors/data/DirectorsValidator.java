package com.ponsun.pep.getDirectors.data;


import com.ponsun.pep.getDirectors.request.CreateGetDirectorsRequest;
import com.ponsun.pep.getDirectors.request.UpdateGetDirectorsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DirectorsValidator {
    public void validateSaveGetDirectors(final CreateGetDirectorsRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("DirectorName parameter is required");
        }
    }
    public void validateUpdateGetDirectors(final UpdateGetDirectorsRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("DirectorName parameter is required");
        }
    }
}
