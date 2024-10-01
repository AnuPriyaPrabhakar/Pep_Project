package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.data;

import lombok.Data;

@Data
public class CompaniesDirectorsData {

    private Integer id;
    private Integer directorId;
    private Integer companyId;
    private Integer designationId;
    private Integer companyMasterId;
    private String appointmentDate;
    private String cessationDate;
    private Integer uid;
    private Integer euid;

    public CompaniesDirectorsData (final Integer id,final Integer directorId, final Integer companyId,final Integer designationId, final Integer companyMasterId,final String appointmentDate , final String cessationDate, final Integer uid,final Integer euid){
        this.id = id;
        this.directorId = directorId;
        this.companyId = companyId;
        this.designationId = designationId;
        this.companyMasterId = companyMasterId;
        this.appointmentDate = appointmentDate;
        this.cessationDate = cessationDate;
        this.uid = uid;
        this.euid = euid;
    }

    public static CompaniesDirectorsData newInstance (final Integer id,final Integer directorId,  final Integer companyId,final Integer designationId,final Integer companyMasterId, final String appointmentDate , final String cessationDate, final Integer uid,final Integer euid){
        return new CompaniesDirectorsData(id,directorId,companyId,designationId,companyMasterId,appointmentDate,cessationDate,uid,euid);
    }
}
