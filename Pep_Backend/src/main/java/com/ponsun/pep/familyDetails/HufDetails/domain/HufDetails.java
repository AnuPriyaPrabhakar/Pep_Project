package com.ponsun.pep.familyDetails.HufDetails.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.request.UpdateHufDetailsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_huf")
public class HufDetails extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "hufName")
    private String hufName;

    @Column(name = "hufPan")
    private String hufPan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;



    public static HufDetails create(CreateHufDetailsRequest createHufDetailsRequest){
        final HufDetails hufDetails = new HufDetails();
        hufDetails.setPepId(createHufDetailsRequest.getPepId());
        hufDetails.setHufName(createHufDetailsRequest.getHufName());
        hufDetails.setHufPan(createHufDetailsRequest.getHufPan());
        hufDetails.setUid(createHufDetailsRequest.getUid());
        hufDetails.setEuid(createHufDetailsRequest.getEuid());
        hufDetails.setStatus(Status.ACTIVE);
        hufDetails.setCreatedAt(LocalDateTime.now());
        return hufDetails;
    }

    public void update(final UpdateHufDetailsRequest updateHufDetailsRequest){
        this.setPepId(updateHufDetailsRequest.getPepId());
        this.setHufName(updateHufDetailsRequest.getHufName());
        this.setHufPan(updateHufDetailsRequest.getHufPan());
        this.setUid(updateHufDetailsRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
