package com.ponsun.pep.categoryCommon.Organization.services;

import com.ponsun.pep.categoryCommon.Organization.data.OrganizationData;

import java.util.List;

public interface OrganizationRedPlatformService {

    List<OrganizationData> fetchAllOrganizationData(String companyName);
}
