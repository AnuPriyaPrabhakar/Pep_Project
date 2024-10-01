package com.ponsun.pep.cutomerAllData.services;

import com.ponsun.pep.cutomerAllData.data.CustomerAllDataData;

import java.util.List;

public interface CustomerAllDataWritePlatformService {
    List<CustomerAllDataData> fetchAllCustomerData();
}
