package com.ponsun.pep.relativeDetails.Relativedet.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.request.UpdateRelativeDetRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_relative_det")
public class RelativeDet extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id" ,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "pan")
    private String pan;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "relativeId")
    private Integer relativeId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private  Integer euid;


    public static RelativeDet create(final CreateRelativeDetRequest createRelativeDetRequest){
        final RelativeDet relativeDet = new RelativeDet();
        relativeDet.setName(createRelativeDetRequest.getName());
        relativeDet.setPan(createRelativeDetRequest.getPan());
        relativeDet.setPepId(createRelativeDetRequest.getPepId());
        relativeDet.setRelativeId(createRelativeDetRequest.getRelativeId());
        relativeDet.setUid(createRelativeDetRequest.getUid());
        relativeDet.setCreatedAt(LocalDateTime.now());
        relativeDet.setStatus(Status.ACTIVE);
        return relativeDet;
    }

    public void update(final UpdateRelativeDetRequest updateRelativeDetRequest){
        this.setName(updateRelativeDetRequest.getName());
        this.setPan(updateRelativeDetRequest.getPan());
        this.setPepId(updateRelativeDetRequest.getPepId());
        this.setRelativeId(updateRelativeDetRequest.getRelativeId());
        this.setEuid(updateRelativeDetRequest.getEuid());
        this.setUpdatedAt(LocalDateTime.now());
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(final UpdateRelativeDetRequest updateRelativeDetRequest){
        this.setEuid(updateRelativeDetRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }

}
