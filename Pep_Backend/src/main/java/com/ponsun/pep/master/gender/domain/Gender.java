package com.ponsun.pep.master.gender.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.gender.request.CreateGenderRequest;
import com.ponsun.pep.master.gender.request.UpdateGenderRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_gender")
@EqualsAndHashCode(callSuper = false)
public class Gender extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gender")
    private String gender;

}
