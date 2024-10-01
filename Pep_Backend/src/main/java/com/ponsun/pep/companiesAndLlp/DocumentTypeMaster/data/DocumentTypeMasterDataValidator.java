package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.data;

import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.UpdateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.CreateDocumentTypeMasterRequest;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.UpdateDocumentTypeMasterRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentTypeMasterDataValidator {
    public void validateSaveDocumentTypeMaster(final CreateDocumentTypeMasterRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("Name parameter required");
        }
    }
    public void validateUpdateDocumentTypeMaster(final UpdateDocumentTypeMasterRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }

}
