package com.ponsun.pep.searchLifcycle.HitRecord.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.request.UpdateHitRecordRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name="hitrecord")
public class HitRecord  extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="searchId")
    private Integer searchId;

    @Column(name="display")
    private String display;

    @Column(name="criminalId")
    private Integer criminalId;

    @Column(name="fileType")
    private Integer fileType;

    @Column(name="matchingScore")
    private Double matchingScore;

    @Column(name="name")
    private String name;

    @Column(name="statusNowId")
    private Integer statusNowId;

    @Column(name="cycleId")
    private Integer cycleId;

    @Column(name="uid")
    private Integer uid;

    @Column(name="valid")
    private Boolean valid;

    public static HitRecord create(final CreateHitRecordRequest createHitRecordRequest){
        final HitRecord hitRecord = new HitRecord();
        hitRecord.setSearchId(createHitRecordRequest.getSearchId());
        hitRecord.setDisplay(createHitRecordRequest.getDisplay());
        hitRecord.setCriminalId(createHitRecordRequest.getCriminalId());
        hitRecord.setFileType(createHitRecordRequest.getFileType());
        hitRecord.setMatchingScore(createHitRecordRequest.getMatchingScore());
        hitRecord.setName(createHitRecordRequest.getName());
        hitRecord.setStatusNowId(createHitRecordRequest.getStatusNowId());
        hitRecord.setCycleId(createHitRecordRequest.getCycleId());
        hitRecord.setValid(createHitRecordRequest.getValid());
        hitRecord.setStatus(Status.ACTIVE);
        return hitRecord;
    }

    public void update(final UpdateHitRecordRequest updateHitRecordRequest){
        this.setSearchId(updateHitRecordRequest.getSearchId());
        this.setDisplay(updateHitRecordRequest.getDisplay());
        this.setCriminalId(updateHitRecordRequest.getCriminalId());
        this.setFileType(updateHitRecordRequest.getFileType());
        this.setMatchingScore(updateHitRecordRequest.getMatchingScore());
        this.setName(updateHitRecordRequest.getName());
        this.setStatusNowId(updateHitRecordRequest.getStatusNowId());
        this.setCycleId(updateHitRecordRequest.getCycleId());
        this.setValid(updateHitRecordRequest.getValid());
        this.setStatus(Status.ACTIVE);
        this.setCreatedAt(LocalDateTime.now());
    }
}
