package com.ponsun.pep.relativeDetails.FamilyDocuments.data;


import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.UpdateFamilyDocumentsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FamilyDocumentsDataValidator {
    public void validateSaveFamilyDocuments(final CreateFamilyDocumentsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateFamilyDocuments(final UpdateFamilyDocumentsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
