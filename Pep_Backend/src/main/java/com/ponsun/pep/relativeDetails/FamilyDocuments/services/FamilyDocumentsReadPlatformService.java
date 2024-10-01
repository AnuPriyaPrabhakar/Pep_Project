package com.ponsun.pep.relativeDetails.FamilyDocuments.services;



import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocuments;

import java.util.List;

public interface FamilyDocumentsReadPlatformService {
    List<FamilyDocuments> fetchAllFamilyDocuments();

    FamilyDocuments fetchFamilyDocumentsById(Integer id);
}
