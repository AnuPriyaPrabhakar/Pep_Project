package com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.CreateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.UpdateCompanyAssociationRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_company_other_association")
public class CompanyAssociation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "companyId")
    private Integer companyId;

    @Lob
    @Column(name ="companyAssociation",columnDefinition = "TEXT")
    private String companyAssociation;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CompanyAssociation create(final CreateCompanyAssociationRequest createOtherAssociationRequest){
        final CompanyAssociation companyAssociation = new CompanyAssociation();
        companyAssociation.setCompanyId(createOtherAssociationRequest.getCompanyId());
        companyAssociation.setCompanyAssociation(createOtherAssociationRequest.getCompanyAssociation());
        companyAssociation.setUid(createOtherAssociationRequest.getUid());
        companyAssociation.onCreate();
        companyAssociation.setStatus(Status.ACTIVE);
        return companyAssociation;
    }
    public void update(UpdateCompanyAssociationRequest updateOtherAssociationRequest){
        this.setCompanyId(updateOtherAssociationRequest.getCompanyId());
        this.setCompanyAssociation(updateOtherAssociationRequest.getCompanyAssociation());
        this.setEuid(updateOtherAssociationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
public void deactive (UpdateCompanyAssociationRequest updateOtherAssociationRequest){
        this.setEuid(updateOtherAssociationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
}
}
