package com.ponsun.pep.getCompanyName.services;

import com.ponsun.pep.getCompanyName.data.GetCompanyNameData;
import java.util.List;

public interface GetCompanyNameWritePlatformService {
    List<GetCompanyNameData> fetchAllGetCompanyNameData(String companyName);

    Integer getCompanyId(String cinfcrn);
}
