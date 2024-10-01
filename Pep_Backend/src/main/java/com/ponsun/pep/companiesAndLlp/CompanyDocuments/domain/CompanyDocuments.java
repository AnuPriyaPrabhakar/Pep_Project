package com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.CreateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.UpdateCompanyDocumentsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_document_companies")
public class CompanyDocuments extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "pathId")
    private Integer pathId;

    @Column(name = "url")
    private String url;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "documentCount")
    private Integer documentCount;



    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static CompanyDocuments create (final CreateCompanyDocumentsRequest createCompanyDocumentsRequest) {
        final CompanyDocuments companyDocuments = new CompanyDocuments();
        companyDocuments.setCompanyId(createCompanyDocumentsRequest.getCompanyId());
        companyDocuments.setPathId(createCompanyDocumentsRequest.getPathId());
        companyDocuments.setUrl(createCompanyDocumentsRequest.getUrl());
        companyDocuments.setDocumentType(createCompanyDocumentsRequest.getDocumentType());
        companyDocuments.setDocumentCount(createCompanyDocumentsRequest.getDocumentCount());
        companyDocuments.setUid(createCompanyDocumentsRequest.getUid());
        companyDocuments.setStatus(Status.ACTIVE);
        companyDocuments.onCreate();
        return companyDocuments;
    }

    public void update (final UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest){
        this.setCompanyId(updateCompanyDocumentsRequest.getCompanyId());
        this.setPathId(updateCompanyDocumentsRequest.getPathId());
        this.setUrl(updateCompanyDocumentsRequest.getUrl());
        this.setDocumentType(updateCompanyDocumentsRequest.getDocumentType());
        this.setDocumentCount(updateCompanyDocumentsRequest.getDocumentCount());
        this.setUid(updateCompanyDocumentsRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.onCreate();
    }

    public void deactive(final UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest) {
        this.setEuid(updateCompanyDocumentsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
