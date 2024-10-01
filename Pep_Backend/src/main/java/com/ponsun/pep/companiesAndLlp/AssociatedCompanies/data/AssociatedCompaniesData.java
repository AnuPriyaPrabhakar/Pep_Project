package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data;

import lombok.Data;
@Data
public class AssociatedCompaniesData {
    private Integer id;
    private Integer directorId;
    private String companyName;
    private Integer associateMasterId;
    private String sourceLink;
    private String CINFCRN;
    private String originalDateOfAppointment;
    private Integer listAdverseInformation;
    private Integer listRegulatoryAction;
    private Integer listGovernment;
    private Integer typeId;
    private Integer uid;
    private Integer euid;
    public AssociatedCompaniesData (final Integer id,final Integer directorId ,final String companyName,final Integer associateMasterId, final String sourceLink,final String CINFCRN,final String originalDateOfAppointment,final Integer listAdverseInformation ,final Integer listRegulatoryAction, final Integer listGovernment,final Integer typeId,final Integer uid,final Integer euid){
        this.id = id;
        this.directorId = directorId;
        this.companyName = companyName;
        this.associateMasterId=associateMasterId;
        this.sourceLink=sourceLink;
        this.CINFCRN = CINFCRN;
        this.originalDateOfAppointment = originalDateOfAppointment;
        this.listAdverseInformation = listAdverseInformation;
        this.listRegulatoryAction = listRegulatoryAction;
        this.listGovernment = listGovernment;
        this.typeId = typeId;
        this.uid = uid;
        this.euid = euid;
    }
    public static  AssociatedCompaniesData newInstance (final Integer id,final Integer directorId ,final String companyName,final Integer associateMasterId, final String sourceLink,final String CINFCRN,final String originalDateOfAppointment,final Integer listAdverseInformation ,final Integer listRegulatoryAction, final Integer listGovernment,final Integer typeId, Integer uid,final Integer euid){
        return new AssociatedCompaniesData(id,directorId,companyName, associateMasterId,sourceLink,CINFCRN, originalDateOfAppointment,listAdverseInformation, listRegulatoryAction, listGovernment,typeId,uid,euid);
    }
}
