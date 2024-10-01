package com.ponsun.pep.companiesAndLlp.CompanyAssociation.request;

import lombok.Data;

@Data
public class AbstractCompanyAssociationRequest {
    private Integer id;
    private Integer companyId;
    private String companyAssociation;
    private Integer uid;
    private Integer euid;
}
