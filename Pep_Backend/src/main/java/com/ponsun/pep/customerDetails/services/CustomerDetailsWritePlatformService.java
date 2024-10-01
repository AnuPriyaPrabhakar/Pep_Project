package com.ponsun.pep.customerDetails.services;

import com.ponsun.pep.customerDetails.data.CustomerDetailsData;

import java.util.List;

public interface CustomerDetailsWritePlatformService {

    List<CustomerDetailsData> fetchAllCustomerDetailsData();

}
