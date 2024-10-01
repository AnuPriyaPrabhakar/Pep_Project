package com.ponsun.pep.category.data;

import com.ponsun.pep.category.request.CreateCategoryRequest;
import com.ponsun.pep.category.request.UpdateCategoryRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class CategoryDataValidator {
    public void validateSaveCategory(final CreateCategoryRequest request){
        if (request.getName()== null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateCategory(final UpdateCategoryRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
