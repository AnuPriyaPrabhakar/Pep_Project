package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services;

import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDet;

import java.util.List;

public interface AssCompanyContactDetReadPlatformService {
    List<AssCompanyContactDet> fetchAllCompanyContactDet();
    AssCompanyContactDet fetchCompanyContactDetById(Integer id);
}
