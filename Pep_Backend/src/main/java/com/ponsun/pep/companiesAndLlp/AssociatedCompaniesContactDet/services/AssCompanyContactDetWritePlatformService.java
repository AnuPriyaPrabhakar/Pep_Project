package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services;

import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.CreateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.UpdateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyContactDTO;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface AssCompanyContactDetWritePlatformService {
    Response createCompanyContactDet(CreateAssCompanyContactDetRequest createAssCompanyContactDetRequest);
    Response updateCompanyContactDet(Integer id, UpdateAssCompanyContactDetRequest updateAssCompanyContactDetRequest);
    Response blockCompanyContactDet(Integer id);
    Response unblockCompanyContactDet(Integer id);
    Response deactive(Integer companyId, Integer euid);
    List<CompanyContactDTO> fetchAllAssCompanyContactDetData(Integer companyId);
}
