package com.ponsun.pep.relativeDetails.FamilyDocuments.domain;



import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.UpdateFamilyDocumentsRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_document_family")

public class FamilyDocuments extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "documentType")
    private String documentType;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "pathId")
    private Integer pathId;

    @Column(name = "relativeMasterId")
    private Integer relativeMasterId;

    @Column(name = "documentCount")
    private Integer documentCount;

    @Column(name = "documentNameList")
    private String documentNameList;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static FamilyDocuments create (final CreateFamilyDocumentsRequest createFamilyDocumentsRequest) {
        final FamilyDocuments familyDocuments = new FamilyDocuments();
        familyDocuments.setDocumentType(createFamilyDocumentsRequest.getDocumentType());
        familyDocuments.setPepId(createFamilyDocumentsRequest.getPepId());
        familyDocuments.setPathId(createFamilyDocumentsRequest.getPathId());
        familyDocuments.setRelativeMasterId(createFamilyDocumentsRequest.getRelativeMasterId());
        familyDocuments.setDocumentCount(createFamilyDocumentsRequest.getDocumentCount());
        familyDocuments.setDocumentNameList(createFamilyDocumentsRequest.getDocumentNameList());
        familyDocuments.setUid(createFamilyDocumentsRequest.getUid());
        familyDocuments.setStatus(Status.ACTIVE);
        familyDocuments.onCreate();
        return familyDocuments;
    }

    public void update (final UpdateFamilyDocumentsRequest updateFamilyDocumentsRequest){
        this.setDocumentType(updateFamilyDocumentsRequest.getDocumentType());
        this.setPepId(updateFamilyDocumentsRequest.getPepId());
        this.setRelativeMasterId(updateFamilyDocumentsRequest.getRelativeMasterId());
        this.setDocumentCount(updateFamilyDocumentsRequest.getDocumentCount());
        this.setDocumentNameList(updateFamilyDocumentsRequest.getDocumentNameList());
        this.setUid(updateFamilyDocumentsRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
    }
}
