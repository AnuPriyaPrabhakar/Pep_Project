package com.ponsun.pep.companiesAndLlp.CompanyAssociation.services;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAssociationDTO;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.CreateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.UpdateCompanyAssociationRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface CompanyAssociationWritePlatformService {
    Response createCompanyAssociation(CreateCompanyAssociationRequest createCompanyAssociationRequest);
    Response updateCompanyAssociation(Integer id, UpdateCompanyAssociationRequest updateCompanyAssociationRequest);
   Response blockCompanyAssociation(Integer id);
   Response unblockCompanyAssociation(Integer id);

   Response deActive(Integer companyId, Integer euid);


    List<CompanyAssociationDTO> fetchAllAsCompanyAssociationData(Integer companyId);
}
