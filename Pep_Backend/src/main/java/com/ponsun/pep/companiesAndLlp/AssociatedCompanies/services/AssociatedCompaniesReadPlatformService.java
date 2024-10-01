package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services;

import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;

import java.util.List;

public interface AssociatedCompaniesReadPlatformService {
    AssociatedCompanies fetchAssociatedCompaniesById(Integer id);
    List<AssociatedCompanies> fetchAllAssociatedCompanies();
}
