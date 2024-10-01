package com.ponsun.pep.master.CompanyMaster.service;

import com.ponsun.pep.master.CompanyMaster.request.CreateCompanyMasterRequest;
import com.ponsun.pep.master.CompanyMaster.request.UpdateCompanyMasterRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface CompanyMasterWritePlatformService {
    Response createCompanyMaster(CreateCompanyMasterRequest createCompanyMasterRequest);

    Response updateCompanyMaster(Integer id, UpdateCompanyMasterRequest updateCompanyMasterRequest);
}
