package com.ponsun.pep.spouse.spouseMother.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.spouse.spouseMother.request.CreateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.request.UpdateSpouseMotherRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_spouse_mother")
public class SpouseMother extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "spouseId")
    private Integer spouseId;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "motherPan")
    private String motherPan;

    @Column(name = "uid")
    private Integer uid;


    @Column(name = "euid")
    private Integer euid;


    public static SpouseMother create(final CreateSpouseMotherRequest createSpouseMotherRequest){
        final SpouseMother spouseMother = new SpouseMother();
        spouseMother.setSpouseId(createSpouseMotherRequest.getSpouseId());
        spouseMother.setMotherPan(createSpouseMotherRequest.getMotherPan());
        spouseMother.setMotherName(createSpouseMotherRequest.getMotherName());
        spouseMother.setPepId(createSpouseMotherRequest.getPepId());
        spouseMother.setUid(createSpouseMotherRequest.getUid());
        spouseMother.setStatus(Status.ACTIVE);
        spouseMother.setCreatedAt(LocalDateTime.now());
        return spouseMother;
    }
    public void update(final UpdateSpouseMotherRequest updateSpouseMotherRequest){
        this.setSpouseId(updateSpouseMotherRequest.getSpouseId());
        this.setMotherName(updateSpouseMotherRequest.getMotherName());
        this.setMotherPan(updateSpouseMotherRequest.getMotherPan());
        this.setPepId(updateSpouseMotherRequest.getPepId());
        this.setEuid(updateSpouseMotherRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void deactive(UpdateSpouseMotherRequest updateSpouseMotherRequest){
        this.setEuid(updateSpouseMotherRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }


}

