package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.CreateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.UpdateAssociatedCompaniesRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_associated_companies")
public class  AssociatedCompanies extends BaseEntity {
    private static final long  serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "directorId")
    private Integer directorId;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "associateMasterId")
    private Integer associateMasterId;

    @Lob
    @Column(name = "sourceLink",columnDefinition = "TEXT")
    private String sourceLink;

    @Column(name = "CINFCRN")
    private String CINFCRN;

    @Column(name = "originalDateOfAppointment")
    private String originalDateOfAppointment;

    @Column(name = "listAdverseInformation")
    private Integer listAdverseInformation;

    @Column(name = "listRegulatoryAction")
    private Integer listRegulatoryAction;

    @Column(name = "listGovernment")
    private Integer listGovernment;

    @Column(name = "typeId")
    private Integer typeId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static AssociatedCompanies create(final CreateAssociatedCompaniesRequest createAssociatedCompaniesRequest){
        final AssociatedCompanies companies = new AssociatedCompanies();
        companies.setId(createAssociatedCompaniesRequest.getId());
        companies.setDirectorId(createAssociatedCompaniesRequest.getDirectorId());
        companies.setAssociateMasterId(createAssociatedCompaniesRequest.getAssociateMasterId());
        companies.setSourceLink(createAssociatedCompaniesRequest.getSourceLink());
        companies.setCINFCRN(createAssociatedCompaniesRequest.getCINFCRN());
        companies.setCompanyName(createAssociatedCompaniesRequest.getCompanyName());
        companies.setOriginalDateOfAppointment(createAssociatedCompaniesRequest.getOriginalDateOfAppointment());
        companies.setListAdverseInformation(createAssociatedCompaniesRequest.getListAdverseInformation());
        companies.setListRegulatoryAction(createAssociatedCompaniesRequest.getListRegulatoryAction());
        companies.setListGovernment(createAssociatedCompaniesRequest.getListGovernment());
        companies.setTypeId(createAssociatedCompaniesRequest.getTypeId());
        companies.setUid(createAssociatedCompaniesRequest.getUid());
        companies.onCreate();
        companies.setStatus(Status.ACTIVE);
        return companies;
    }

    public void  update(final UpdateAssociatedCompaniesRequest updateAssociatedCompaniesRequest){
        this.setDirectorId(updateAssociatedCompaniesRequest.getDirectorId());
        this.setAssociateMasterId(updateAssociatedCompaniesRequest.getAssociateMasterId());
        this.setSourceLink(updateAssociatedCompaniesRequest.getSourceLink());
        this.setCINFCRN(updateAssociatedCompaniesRequest.getCINFCRN());
        this.setCompanyName(updateAssociatedCompaniesRequest.getCompanyName());
        this.setOriginalDateOfAppointment(updateAssociatedCompaniesRequest.getOriginalDateOfAppointment());
        this.setListAdverseInformation(updateAssociatedCompaniesRequest.getListAdverseInformation());
        this.setListRegulatoryAction(updateAssociatedCompaniesRequest.getListRegulatoryAction());
        this.setListGovernment(updateAssociatedCompaniesRequest.getListGovernment());
        this.setTypeId(updateAssociatedCompaniesRequest.getTypeId());
        this.setEuid(updateAssociatedCompaniesRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
    public void deactive(final UpdateAssociatedCompaniesRequest updateAssociatedCompaniesRequest){
        this.setEuid(updateAssociatedCompaniesRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
    }

}
