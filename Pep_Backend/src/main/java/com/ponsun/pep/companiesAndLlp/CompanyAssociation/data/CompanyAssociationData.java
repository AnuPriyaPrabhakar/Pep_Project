package com.ponsun.pep.companiesAndLlp.CompanyAssociation.data;

import lombok.Data;

@Data
public class CompanyAssociationData {
    private Integer id;
    private Integer companyId;
    private String companyAssociation;
    private Integer uid;
    private Integer euid;

    public CompanyAssociationData(final Integer id, final Integer companyId, final String companyAssociation, final Integer uid, final Integer euid){
        this.id = id;
        this.companyId = companyId;
        this.companyAssociation = companyAssociation;
        this.uid = uid;
        this.euid = euid;
    }
    public static CompanyAssociationData newInstance(final Integer id, final Integer companyId, final String companyAssociation, final Integer uid, final Integer euid){
        return new CompanyAssociationData(id,companyId,companyAssociation,uid,euid);
    }
}
