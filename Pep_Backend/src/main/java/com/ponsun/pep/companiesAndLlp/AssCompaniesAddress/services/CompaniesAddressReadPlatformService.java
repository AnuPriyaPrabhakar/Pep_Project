package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddress;

import java.util.List;
public interface CompaniesAddressReadPlatformService {


    CompaniesAddress fetchCompaniesAddressById(Integer id);

    List<CompaniesAddress> fetchAllCompaniesAddress();
}
