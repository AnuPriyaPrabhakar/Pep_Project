package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.CreateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.UpdateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAddressDTO;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface CompaniesAddressWritePlatformService {


    Response createCompaniesAddress(CreateCompaniesAddressRequest createCompaniesAddressRequest);

    Response updateCompaniesAddress(Integer id, UpdateCompaniesAddressRequest updateCompaniesAddressRequest);

    Response blockCompaniesAddress(Integer id);

    Response unblockCompaniesAddress(Integer id);

    Response deActive(Integer companyId, Integer euid);

    List<CompanyAddressDTO> fetchAllCompaniesAddressData(Integer companyId);
}
