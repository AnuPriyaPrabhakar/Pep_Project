package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request;

import lombok.Data;

@Data
public class AbstractAssCompanyContactDetRequest {
    private Integer companyId;
    private String emailID;
    private Integer uid;
    private Integer euid;

}
