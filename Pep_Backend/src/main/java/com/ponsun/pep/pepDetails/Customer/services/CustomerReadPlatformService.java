package com.ponsun.pep.pepDetails.Customer.services;

import com.ponsun.pep.master.Country.domain.Country;
import com.ponsun.pep.pepDetails.Customer.data.CustomerData;
import com.ponsun.pep.pepDetails.Customer.domain.Customer;

import java.util.List;

public interface CustomerReadPlatformService {
    Customer fetchCustomerById(Integer id);

    List<Customer> fetchAllCustomer();
}
