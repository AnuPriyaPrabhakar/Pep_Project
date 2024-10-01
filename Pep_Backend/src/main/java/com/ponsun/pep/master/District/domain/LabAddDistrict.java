package com.ponsun.pep.master.District.domain;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "lab_add_district")
public class LabAddDistrict implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ent_uid")
    private Long entUid;

    @Column(name = "ent_date")
    private Date entDate;

    @Column(name = "ent_time")
    private Time entTime;

    @Column(name = "is_blocked")
    private Boolean blocked;

    @Column(name = "blocked_uid")
    private Long blockedUid;

    @Column(name = "block_date")
    private Date blockDate;

    @Column(name = "block_time")
    private Time blockTime;

    @Column(name = "is_blocked_by_system")
    private Boolean blockedBySystem;

    @Column(name = "state_id")
    private Long stateId;

}
