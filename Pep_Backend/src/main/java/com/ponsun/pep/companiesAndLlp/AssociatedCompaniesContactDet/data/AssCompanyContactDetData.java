package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.data;

import lombok.Data;

@Data
public class AssCompanyContactDetData {

    private Integer companyId;
    private String emailID;
    private Integer uid;
    private Integer euid;

    public AssCompanyContactDetData(final Integer companyId  , final String emailID,final Integer uid,final  Integer euid){
        this.companyId = companyId;
        this.emailID = emailID;
        this.uid = uid;
        this.euid = euid;
    }

    public static AssCompanyContactDetData newInstance (final Integer companyId  , final String emailID ,final Integer uid,final Integer euid){
        return new AssCompanyContactDetData(companyId  , emailID ,uid,euid);
    }
}






