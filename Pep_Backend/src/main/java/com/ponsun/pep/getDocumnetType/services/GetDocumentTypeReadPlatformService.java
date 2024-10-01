package com.ponsun.pep.getDocumnetType.services;

import com.ponsun.pep.getDocumnetType.data.GetDocumentTypeData;

import java.util.List;

public interface GetDocumentTypeReadPlatformService {
    List<GetDocumentTypeData> getDocumentType(Integer companyId, Integer pathId);
}
