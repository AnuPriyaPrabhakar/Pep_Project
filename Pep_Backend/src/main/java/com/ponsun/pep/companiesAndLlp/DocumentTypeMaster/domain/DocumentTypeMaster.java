package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.CreateDocumentTypeMasterRequest;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.UpdateDocumentTypeMasterRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Entity
@Accessors(chain = true)
@Table(name ="pep_config_attached_proof")

public class DocumentTypeMaster extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static DocumentTypeMaster create (CreateDocumentTypeMasterRequest createDocumentTypeMasterRequest) {
        final DocumentTypeMaster documentTypeMaster = new DocumentTypeMaster();
        documentTypeMaster.setName(createDocumentTypeMasterRequest.getName());
        documentTypeMaster.setUid(createDocumentTypeMasterRequest.getUid());
        documentTypeMaster.setStatus(Status.ACTIVE);
        documentTypeMaster.setCreatedAt(LocalDateTime.now());
        return documentTypeMaster;
    }
    public void update (final UpdateDocumentTypeMasterRequest updateDocumentTypeMasterRequest){
        this.setName(updateDocumentTypeMasterRequest.getName());
        this.setUid(updateDocumentTypeMasterRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.setCreatedAt(LocalDateTime.now());
    }
    public void deactive(final UpdateDocumentTypeMasterRequest updateDocumentTypeMasterRequest) {
        this.setEuid(updateDocumentTypeMasterRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
