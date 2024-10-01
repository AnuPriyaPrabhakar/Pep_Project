package com.ponsun.pep.pepDetails.OtherAssociation.services;

import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.request.UpdateOtherAssociationRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface OtherAssociationWritePlatformService {
    Response createOtherAssociation(CreateOtherAssociationRequest createOtherAssociationRequest);
    Response updateOtherAssociation(Integer id, UpdateOtherAssociationRequest updateOtherAssociationRequest);
   Response blockOtherAssociation(Integer id);
   Response unblockOtherAssociation(Integer id);
    Response deactive(Integer pepId, Integer euid);


}
