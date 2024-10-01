package com.ponsun.pep.cutomerEdit.services;

import com.ponsun.pep.cutomerEdit.data.CustomerEditData;

import java.util.List;

public interface CustomerEditWritePlatformService {
    List<CustomerEditData> fetchAllCustomerEditData(String fromDate, String toDate );
}
