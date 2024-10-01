package com.ponsun.pep.companiesAndLlp.CompanyMaster.request;

import lombok.Data;

@Data
public class AbstractCompanyRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
