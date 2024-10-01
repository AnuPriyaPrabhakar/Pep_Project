package com.ponsun.pep.companiesAndLlp.CompanyAssociation.services;

import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociation;

import java.util.List;
public interface CompanyAssociationReadPlatformService {
    CompanyAssociation fetchCompanyAssociationById(Integer id);
    List<CompanyAssociation> fetchAllCompanyAssociation();
    List<CompanyAssociation> OtherAssociationFindByPepId(Integer pepId);
}
