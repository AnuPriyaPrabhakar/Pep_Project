package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class CompanyAssociationDTO {
    private Integer id;
    private Integer companyId;
    private String companyAssociation;
    private Integer uid;
    private Integer euid;

    public CompanyAssociationDTO(final Integer id, final Integer companyId, final String companyAssociation, final Integer uid, final Integer euid){
        this.id = id;
        this.companyId = companyId;
        this.companyAssociation = companyAssociation;
        this.uid = uid;
        this.euid = euid;
    }
    public static CompanyAssociationDTO newInstance(final Integer id, final Integer companyId, final String companyAssociation, final Integer uid, final Integer euid){
        return new CompanyAssociationDTO(id,companyId,companyAssociation,uid,euid);
    }
}
