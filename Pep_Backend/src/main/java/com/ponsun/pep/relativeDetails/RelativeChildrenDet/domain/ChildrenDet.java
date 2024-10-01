package com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain;


import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.UpdateChildrenDetRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_relative_det_children")
public class ChildrenDet extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "relativeId")
    private Integer relativeId;

    @Column(name = "relativeDetId")
    private Integer relativeDetId;

    @Column(name = "childrenName")
    private String childrenName;

    @Column(name = "pan")
    private String pan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;



    public static ChildrenDet create (final CreateChildrenDetRequest createChildrenDetRequest) {
        final ChildrenDet childrenDet = new ChildrenDet();
        childrenDet.setPepId(createChildrenDetRequest.getPepId());
        childrenDet.setRelativeId(createChildrenDetRequest.getRelativeId());
        childrenDet.setRelativeDetId(createChildrenDetRequest.getRelativeDetId());
        childrenDet.setChildrenName(createChildrenDetRequest.getChildrenName());
        childrenDet.setPan(createChildrenDetRequest.getPan());
        childrenDet.setUid(createChildrenDetRequest.getUid());
        childrenDet.onCreate();
        childrenDet.setStatus(Status.ACTIVE);
       return childrenDet;
    }
    public void update(final UpdateChildrenDetRequest updateChildrenDetRequest){
        this.setPepId(updateChildrenDetRequest.getPepId());
        this.setRelativeId(updateChildrenDetRequest.getRelativeId());
        this.setRelativeDetId(updateChildrenDetRequest.getRelativeDetId());
        this.setChildrenName(updateChildrenDetRequest.getChildrenName());
        this.setPan(updateChildrenDetRequest.getPan());
        this.setEuid(updateChildrenDetRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(final UpdateChildrenDetRequest updateChildrenDetRequest){
        this.setEuid(updateChildrenDetRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }
}
