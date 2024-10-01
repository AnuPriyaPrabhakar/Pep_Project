package com.ponsun.pep.roles.RoleDetails.domain;

import com.ponsun.pep.roles.RoleDetails.request.CreateRoleDetailsRequest;
import com.ponsun.pep.roles.RoleDetails.request.UpdateRoleDetailsRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_role_details")
public class RoleDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "modId")
    private Integer modId;

    @Column(name = "modDetId")
    private Integer modDetId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static RoleDetails create(CreateRoleDetailsRequest createRoleDetailsRequest){
        final RoleDetails roleDetails = new RoleDetails();
        roleDetails.setRoleId(createRoleDetailsRequest.getRoleId());
        roleDetails.setModId(createRoleDetailsRequest.getModId());
        roleDetails.setModDetId(createRoleDetailsRequest.getModDetId());
        roleDetails.setUid(createRoleDetailsRequest.getUid());
        roleDetails.setStatus(Status.ACTIVE);
        roleDetails.setCreatedAt(LocalDateTime.now());
        return roleDetails;
    }
    public void update(final UpdateRoleDetailsRequest updateRoleDetailsRequest){
        this.setRoleId(updateRoleDetailsRequest.getRoleId());
        this.setModId(updateRoleDetailsRequest.getModId());
        this.setModDetId(updateRoleDetailsRequest.getModDetId());
        this.setEuid(updateRoleDetailsRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void deactive(final UpdateRoleDetailsRequest updateRoleDetailsRequest){
        this.setEuid(updateRoleDetailsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
