package com.ponsun.pep.master.designation.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.designation.request.CreateDesignationRequest;
import com.ponsun.pep.master.designation.request.UpdateDesignationRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_designation")
public class Designation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;



    public static Designation create(final CreateDesignationRequest createDesignationRequest){
        final Designation designation = new Designation();
        designation.setStatus(Status.ACTIVE);
        designation.setCreatedAt(LocalDateTime.now());
        designation.setName(createDesignationRequest.getName());
        return designation;
    }
    public void update (final UpdateDesignationRequest updateDesignationRequest) {

        this.setStatus(Status.ACTIVE);
        this.setCreatedAt(LocalDateTime.now());
        this.setName(updateDesignationRequest.getName());
    }
}