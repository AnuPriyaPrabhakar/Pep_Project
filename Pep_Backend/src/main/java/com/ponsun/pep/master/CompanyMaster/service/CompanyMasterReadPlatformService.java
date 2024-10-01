package com.ponsun.pep.master.CompanyMaster.service;

import com.ponsun.pep.master.CompanyMaster.domain.CompanyMaster;

import java.util.List;

public interface CompanyMasterReadPlatformService {

    List<CompanyMaster> fetchAllCompanyMaster();

    CompanyMaster fetchCompanyMasterById(Integer id);
}
