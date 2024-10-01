package com.ponsun.pep.listOfCompany.services;

import com.ponsun.pep.listOfCompany.domain.ListOfCompany;

import java.util.List;
public interface ListOfCompanyReadPlatformService {
    List<ListOfCompany> fetchAllListOfCompany();
    ListOfCompany fetchListOfCompanyById(Integer id);
}
