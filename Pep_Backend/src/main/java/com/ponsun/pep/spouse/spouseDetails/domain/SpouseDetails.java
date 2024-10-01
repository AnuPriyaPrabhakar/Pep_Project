package com.ponsun.pep.spouse.spouseDetails.domain;


import com.ponsun.pep.common.entity.Status;

import com.ponsun.pep.spouse.spouseDetails.request.CreateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.request.UpdateSpouseDetailsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
//@Accessors(chain = true)
@Table(name = "pep_spouse")
public class SpouseDetails extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "hufId")
    private Integer hufId;

    @Column(name = "spouseName")
    private String spouseName;

    @Column(name = "spousePan")
    private String spousePan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;



    public static SpouseDetails create(CreateSpouseDetailsRequest createSpouseDetailsRequest){
        final SpouseDetails SpouseDetails = new SpouseDetails();
        SpouseDetails.setId(createSpouseDetailsRequest.getId());
        SpouseDetails.setPepId(createSpouseDetailsRequest.getPepId());
        SpouseDetails.setHufId(createSpouseDetailsRequest.getHufId());
        SpouseDetails.setSpouseName(createSpouseDetailsRequest.getSpouseName());
        SpouseDetails.setSpousePan(createSpouseDetailsRequest.getSpousePan());
        SpouseDetails.setUid(createSpouseDetailsRequest.getUid());
        SpouseDetails.setStatus(Status.ACTIVE);
        SpouseDetails.setCreatedAt(LocalDateTime.now());
        return SpouseDetails;
    }

    public void update(final UpdateSpouseDetailsRequest updateSpouseDetailsRequest){
        this.setId(updateSpouseDetailsRequest.getId());
        this.setPepId(updateSpouseDetailsRequest.getPepId());
        this.setHufId(updateSpouseDetailsRequest.getHufId());
        this.setSpouseName(updateSpouseDetailsRequest.getSpouseName());
        this.setSpousePan(updateSpouseDetailsRequest.getSpousePan());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
