package com.ponsun.pep.dinEdit.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.dinEdit.request.CreateDinEditRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="pep_config_companies_directors_log")
public class DinEdit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="din")
    private String din;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static DinEdit create(CreateDinEditRequest createDinEditRequest){
        final DinEdit dinEdit = new DinEdit();
        dinEdit.setName(createDinEditRequest.getName());
        dinEdit.setDin(createDinEditRequest.getDin());
        dinEdit.setUid(createDinEditRequest.getUid());
       dinEdit.setStatus(Status.ACTIVE);
       dinEdit.setCreatedAt(LocalDateTime.now());
       return dinEdit;
    }
}
