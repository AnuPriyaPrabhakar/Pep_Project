package com.ponsun.pep.pepDetails.AkaDet.domain;

import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.request.UpdateAkaDetRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_aka_det")
public class AkaDet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "akaName")
    private String akaName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static AkaDet create(CreateAkaDetRequest createAkaDetRequest){
        final AkaDet akaDet = new AkaDet();
        akaDet.setPepId(createAkaDetRequest.getPepId());
        akaDet.setAkaName(createAkaDetRequest.getAkaName());
        akaDet.setUid(createAkaDetRequest.getUid());
        akaDet.setStatus(Status.ACTIVE);
        akaDet.setCreatedAt(LocalDateTime.now());
        return akaDet;
    }
    public void update(final UpdateAkaDetRequest updateAkaDetRequest){
        this.setPepId(updateAkaDetRequest.getPepId());
        this.setAkaName(updateAkaDetRequest.getAkaName());
        this.setEuid(updateAkaDetRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void deactive(final UpdateAkaDetRequest updateAkaDetRequest){
        this.setEuid(updateAkaDetRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
