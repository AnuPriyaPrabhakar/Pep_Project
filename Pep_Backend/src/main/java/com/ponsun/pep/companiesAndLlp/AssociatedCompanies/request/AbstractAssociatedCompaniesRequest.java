package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class AbstractAssociatedCompaniesRequest {
    private Integer id;
    private Integer directorId;
    private String companyName;
    private Integer associateMasterId;
    private String CINFCRN;
    private String sourceLink;
    private String originalDateOfAppointment;
    private Integer listAdverseInformation;
    private Integer listRegulatoryAction;
    private Integer listGovernment;
    private Integer typeId;
    private Integer uid;
    private Integer euid;

}
