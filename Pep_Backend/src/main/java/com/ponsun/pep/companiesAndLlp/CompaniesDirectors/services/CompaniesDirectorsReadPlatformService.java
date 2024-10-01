package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services;

import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectors;

import java.util.List;

public interface CompaniesDirectorsReadPlatformService {


    List<CompaniesDirectors> fetchAllCompaniesAddress();

    CompaniesDirectors fetchCompaniesDirectorsById(Integer id);
}
