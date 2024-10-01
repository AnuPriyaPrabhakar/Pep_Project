package com.ponsun.pep.spouse.spouseHuf.domain;

import com.ponsun.pep.spouse.spouseHuf.request.CreateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseHuf.request.UpdateSpouseHufRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_spouse_huf")
public class SpouseHuf extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "spouseId")
    private Integer spouseId;

    @Column(name = "hufName")
    private String hufName;

    @Column(name = "hufPan")
    private String hufPan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static SpouseHuf create(final CreateSpouseHufRequest createSpouseHufRequest){
        final SpouseHuf spouseHuf = new SpouseHuf();
        spouseHuf.setPepId(createSpouseHufRequest.getPepId());
        spouseHuf.setSpouseId(createSpouseHufRequest.getSpouseId());
        spouseHuf.setHufPan(createSpouseHufRequest.getHufPan());
        spouseHuf.setHufName(createSpouseHufRequest.getHufName());
        spouseHuf.setUid(createSpouseHufRequest.getUid());
        spouseHuf.setStatus(Status.ACTIVE);
        spouseHuf.setCreatedAt(LocalDateTime.now());
        return spouseHuf;
    }
    public void update(final UpdateSpouseHufRequest updateSpouseHufRequest){
        this.setPepId(updateSpouseHufRequest.getPepId());
        this.setSpouseId(updateSpouseHufRequest.getSpouseId());
        this.setHufName(updateSpouseHufRequest.getHufName());
        this.setHufPan(updateSpouseHufRequest.getHufPan());
        this.setEuid(updateSpouseHufRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void deactive(UpdateSpouseHufRequest updateSpouseHufRequest){
        this.setEuid(updateSpouseHufRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }


}

