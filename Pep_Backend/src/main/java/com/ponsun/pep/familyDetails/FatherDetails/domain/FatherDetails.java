package com.ponsun.pep.familyDetails.FatherDetails.domain;
import com.ponsun.pep.common.entity.Status;

import com.ponsun.pep.familyDetails.FatherDetails.request.CreateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.request.UpdateFatherDetailsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_father")
public class FatherDetails extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "fatherPan")
    private String fatherPan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static FatherDetails create(CreateFatherDetailsRequest createFatherDetailsRequest){
        final FatherDetails fatherDetails = new FatherDetails();
        fatherDetails.setPepId(createFatherDetailsRequest.getPepId());
        fatherDetails.setFatherName(createFatherDetailsRequest.getFatherName());
        fatherDetails.setFatherPan(createFatherDetailsRequest.getFatherPan());
        fatherDetails.setUid(createFatherDetailsRequest.getUid());
        fatherDetails.setEuid(createFatherDetailsRequest.getEuid());
        fatherDetails.setStatus(Status.ACTIVE);
        fatherDetails.setCreatedAt(LocalDateTime.now());
        return fatherDetails;
    }
    public void update(final UpdateFatherDetailsRequest updateFatherDetailsRequest){
        this.setPepId(updateFatherDetailsRequest.getPepId());
        this.setFatherName(updateFatherDetailsRequest.getFatherName());
        this.setFatherPan(updateFatherDetailsRequest.getFatherPan());
        this.setUid(updateFatherDetailsRequest.getUid());
        this.setEuid(updateFatherDetailsRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }


}
