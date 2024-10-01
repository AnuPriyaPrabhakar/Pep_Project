package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CompaniesDirectorsDTO {
    private Integer id;
    private Integer companyId;
    private Integer directorId;
    private String directorName;
    private String din;
    private Integer designationId;
    private Integer companyMasterId;
    private String designation;
    private String directorStatus;
    private String appointmentDate;
    private String cessationDate;
    private Integer uid;
    private Integer euid;


    public CompaniesDirectorsDTO (final Integer companyId , final Integer directorId , String directorName, final String din,final Integer designationId,final Integer companyMasterId,  final String designation,final String directorStatus, final String appointmentDate,final String cessationDate,final Integer uid, final Integer euid) {
        this.companyId = companyId;
        this.directorId = directorId;
        this.directorName = directorName;
        this.din=din;
        this.designationId = designationId;
        this.companyMasterId = companyMasterId;
        this.designation = designation;
        this.directorStatus = directorStatus;
        this.appointmentDate = appointmentDate;
        this.cessationDate = cessationDate;
        this.uid = uid;
        this.euid = euid;
    }
    public CompaniesDirectorsDTO newInstance (final Integer companyId , final Integer directorId , String directorName, final String din,final Integer designationId,final Integer companyMasterId,  final String designation,final String directorStatus, final String appointmentDate,final String cessationDate,final Integer uid, final Integer euid) {
        return new CompaniesDirectorsDTO(companyId,directorId,directorName,din,designationId,companyMasterId,designation,directorStatus,appointmentDate,cessationDate,uid,euid);
    }
}