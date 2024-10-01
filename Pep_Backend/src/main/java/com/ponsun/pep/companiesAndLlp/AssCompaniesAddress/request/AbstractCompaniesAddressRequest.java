package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request;

import lombok.Data;

@Data
public class AbstractCompaniesAddressRequest {
    private Integer id;
    private Integer companyId;
    private String registeredAddress;
    private Integer uid;
    private Integer euid;
}
