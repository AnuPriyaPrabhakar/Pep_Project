package com.ponsun.pep.roles.Role.domain;

import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_role")

public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static Role create(CreateRoleRequest createRoleRequest) {
        final Role role = new Role();
        role.setRoleName(createRoleRequest.getRoleName());
        role.setUid(createRoleRequest.getUid());
        role.setStatus(Status.ACTIVE);
        role.setCreatedAt(LocalDateTime.now());
        return role;
    }

    public void update(final UpdateRoleRequest updateRoleRequest) {
        this.setRoleName(updateRoleRequest.getRoleName());
        this.setEuid(updateRoleRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void deactive(final UpdateRoleRequest updateRoleRequest) {
        this.setEuid(updateRoleRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
