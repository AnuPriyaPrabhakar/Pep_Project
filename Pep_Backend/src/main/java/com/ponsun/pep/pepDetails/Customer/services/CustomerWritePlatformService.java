package com.ponsun.pep.pepDetails.Customer.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.Country.request.CreateCountryRequest;
import com.ponsun.pep.master.Country.request.UpdateCountryRequest;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.request.UpdateCustomerRequest;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerWritePlatformService {
    Response createCustomer(CreateCustomerRequest createCustomerRequest);

    Response updateCustomer(Integer id, UpdateCustomerRequest updateCustomerRequest);

    Response deleteCustomer(Integer id);

    Response checked(String checked);


//    Response deactive(Integer pepId, Integer euid);
}
