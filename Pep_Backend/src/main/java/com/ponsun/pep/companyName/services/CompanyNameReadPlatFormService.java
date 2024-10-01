package com.ponsun.pep.companyName.services;

import com.ponsun.pep.companyName.data.CompanyNameData;

import java.util.List;

public interface CompanyNameReadPlatFormService {
    List<CompanyNameData> getCompanyName(String din, String pan);
}
