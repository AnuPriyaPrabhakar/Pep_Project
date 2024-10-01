package com.ponsun.pep.master.AssociatedList.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.master.AssociatedList.request.CreateAssociatedListRequest;
import com.ponsun.pep.master.AssociatedList.request.UpdateAssociatedListRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssociatedListDataValidator {
    public void validateSaveAssociatedList(final CreateAssociatedListRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateAssociatedList(final UpdateAssociatedListRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}