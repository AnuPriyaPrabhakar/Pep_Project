package com.ponsun.pep.pepDetails.OtherAssociation.services;

import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociation;

import java.util.List;
public interface OtherAssociationReadPlatformService {
    OtherAssociation fetchOtherAssociationById(Integer id);
    List<OtherAssociation> fetchAllOtherAssociation();
    List<OtherAssociationData> OtherAssociationFindByPepId(Integer pepId);
}
