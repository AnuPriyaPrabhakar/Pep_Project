package com.ponsun.pep.spouse.spouseFather.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.spouse.spouseFather.request.CreateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.request.UpdateSpouseFatherRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_spouse_father")
public class SpouseFather extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "spouseId")
    private Integer spouseId;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "fatherPan")
    private String fatherPan;

    @Column(name = "uid")
    private Integer uid;


    @Column(name = "euid")
    private Integer euid;


    public static SpouseFather create(final CreateSpouseFatherRequest createSpouseMotherRequest){
        final SpouseFather spouseFather = new SpouseFather();
        spouseFather.setId(createSpouseMotherRequest.getId());
        spouseFather.setPepId(createSpouseMotherRequest.getPepId());
        spouseFather.setSpouseId(createSpouseMotherRequest.getSpouseId());
        spouseFather.setFatherPan(createSpouseMotherRequest.getFatherPan());
        spouseFather.setFatherName(createSpouseMotherRequest.getFatherName());
        spouseFather.setUid(createSpouseMotherRequest.getUid());
        spouseFather.setEuid(createSpouseMotherRequest.getEuid());
        spouseFather.setStatus(Status.ACTIVE);
        spouseFather.setCreatedAt(LocalDateTime.now());
        return spouseFather;
    }
    public void update(final UpdateSpouseFatherRequest updateSpouseFatherRequest){
        this.setPepId(updateSpouseFatherRequest.getPepId());
        this.setSpouseId(updateSpouseFatherRequest.getSpouseId());
        this.setFatherName(updateSpouseFatherRequest.getFatherName());
        this.setFatherPan(updateSpouseFatherRequest.getFatherPan());
        this.setEuid(updateSpouseFatherRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void deactive(UpdateSpouseFatherRequest updateSpouseFatherRequest){
        this.setEuid(updateSpouseFatherRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }


}

