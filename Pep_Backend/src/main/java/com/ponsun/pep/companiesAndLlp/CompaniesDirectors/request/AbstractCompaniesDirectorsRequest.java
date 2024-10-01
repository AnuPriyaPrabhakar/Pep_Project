package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request;
import lombok.Data;

@Data
public class AbstractCompaniesDirectorsRequest {
    private Integer id;
    private Integer directorId;
    private Integer companyId;
    private Integer designationId;
    private Integer companyMasterId;
    private String appointmentDate;
    private String cessationDate;
    private Integer uid;
    private Integer euid;

}
