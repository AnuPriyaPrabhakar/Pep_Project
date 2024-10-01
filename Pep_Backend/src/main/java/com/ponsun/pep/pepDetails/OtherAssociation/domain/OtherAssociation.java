package com.ponsun.pep.pepDetails.OtherAssociation.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.request.UpdateOtherAssociationRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_other_association")
public class OtherAssociation  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Lob
    @Column(name ="otherAssociationAsPerMedia",columnDefinition = "TEXT")
    private String otherAssociationAsPerMedia;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static OtherAssociation create(final CreateOtherAssociationRequest createOtherAssociationRequest){
        final OtherAssociation otherAssociation = new OtherAssociation();
        otherAssociation.setPepId(createOtherAssociationRequest.getPepId());
        otherAssociation.setOtherAssociationAsPerMedia(createOtherAssociationRequest.getOtherAssociationAsPerMedia());
        otherAssociation.setUid(createOtherAssociationRequest.getUid());
        otherAssociation.onCreate();
        otherAssociation.setStatus(Status.ACTIVE);
        return otherAssociation;
    }
    public void update(UpdateOtherAssociationRequest updateOtherAssociationRequest){
        this.setPepId(updateOtherAssociationRequest.getPepId());
        this.setOtherAssociationAsPerMedia(updateOtherAssociationRequest.getOtherAssociationAsPerMedia());
        this.setEuid(updateOtherAssociationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
public void deactive (UpdateOtherAssociationRequest updateOtherAssociationRequest){
        this.setEuid(updateOtherAssociationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
}
}
