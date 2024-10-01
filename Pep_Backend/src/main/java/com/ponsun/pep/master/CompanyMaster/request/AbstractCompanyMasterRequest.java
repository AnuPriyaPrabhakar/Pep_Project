package com.ponsun.pep.master.CompanyMaster.request;

import lombok.Data;

@Data
public class AbstractCompanyMasterRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
