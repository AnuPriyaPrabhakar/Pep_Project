package com.ponsun.pep.relativeDetails.FamilyDocuments.services;


import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.UpdateFamilyDocumentsRequest;
import com.ponsun.pep.infrastructure.utils.Response;



public interface FamilyDocumentsWritePlatformService {

    Response createFamilyDocuments(CreateFamilyDocumentsRequest createFamilyDocumentsRequest);

    Response updateFamilyDocuments(Integer id, UpdateFamilyDocumentsRequest updateFamilyDocumentsRequest);
}
