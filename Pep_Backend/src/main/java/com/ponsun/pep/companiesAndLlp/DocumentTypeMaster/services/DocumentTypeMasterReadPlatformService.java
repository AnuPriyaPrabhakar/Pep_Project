package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services;

import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMaster;

import java.util.List;

public interface DocumentTypeMasterReadPlatformService {
    List<DocumentTypeMaster> fetchAllDocumentTypeMaster();


    DocumentTypeMaster fetchDocumentTypeMasterById(Integer id);
}
