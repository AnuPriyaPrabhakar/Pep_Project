package com.ponsun.pep.familyDetails.MotherDetails.domain;


import com.ponsun.pep.common.entity.Status;

import com.ponsun.pep.familyDetails.MotherDetails.request.CreateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.request.UpdateMotherDetailsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_mother")
public class MotherDetails extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "hufId")
    private Integer hufId;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "motherPan")
    private String motherPan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;



    public static MotherDetails create(CreateMotherDetailsRequest createMotherDetailsRequest){
        final MotherDetails motherDetails = new MotherDetails();
        motherDetails.setPepId(createMotherDetailsRequest.getPepId());
        motherDetails.setHufId(createMotherDetailsRequest.getHufId());
        motherDetails.setMotherName(createMotherDetailsRequest.getMotherName());
        motherDetails.setMotherPan(createMotherDetailsRequest.getMotherPan());
        motherDetails.setUid(createMotherDetailsRequest.getUid());
        motherDetails.setStatus(Status.ACTIVE);
        motherDetails.setCreatedAt(LocalDateTime.now());
        return motherDetails;
    }

    public void update(final UpdateMotherDetailsRequest updateMotherDetailsRequest){
        this.setPepId(updateMotherDetailsRequest.getPepId());
        this.setHufId(updateMotherDetailsRequest.getHufId());
        this.setMotherName(updateMotherDetailsRequest.getMotherName());
        this.setMotherPan(updateMotherDetailsRequest.getMotherPan());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
