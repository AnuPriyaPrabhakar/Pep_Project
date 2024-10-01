package com.ponsun.pep.listOfCompany.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.listOfCompany.request.CreateListOfCompanyRequest;
import com.ponsun.pep.listOfCompany.request.UpdateListOfCompanyRequest;

public interface ListOfCompanyWritePlatformService {
    Response createListOfCompany(CreateListOfCompanyRequest createListOfCompanyRequest);
    Response updateListOfCompany(Integer id, UpdateListOfCompanyRequest updateListOfCompanyRequest);
}
