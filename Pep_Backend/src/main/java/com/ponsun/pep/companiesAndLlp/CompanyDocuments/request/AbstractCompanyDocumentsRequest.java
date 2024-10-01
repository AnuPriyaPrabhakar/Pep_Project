package com.ponsun.pep.companiesAndLlp.CompanyDocuments.request;

import lombok.Data;

@Data
public class AbstractCompanyDocumentsRequest {
    private Integer id;
    private Integer companyId;
    private Integer pathId;
    private String url ;
    private String documentType;
    private Integer documentCount;
    private Integer uid;
    private Integer euid;
}
