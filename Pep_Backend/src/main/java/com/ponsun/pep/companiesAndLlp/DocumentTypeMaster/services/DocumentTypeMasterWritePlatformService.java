package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services;

import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.CreateDocumentTypeMasterRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface DocumentTypeMasterWritePlatformService {
    Response createDocumentTypeMaster(CreateDocumentTypeMasterRequest createDocumentTypeMasterRequest);

    Integer getDocumentType(String documentType, CreateDocumentTypeMasterRequest createDocumentTypeMasterRequest);
}
