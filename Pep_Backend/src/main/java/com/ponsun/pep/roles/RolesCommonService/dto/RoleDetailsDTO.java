package com.ponsun.pep.roles.RolesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RoleDetailsDTO {
    private Integer roleId;
    private Integer modId;
    private Integer modDetId;
    private Integer uid;
    private Integer euid;

    public RoleDetailsDTO(Integer roleId, Integer modId, Integer modDetId, Integer uid, Integer euid) {
        this.roleId = roleId;
        this.modId = modId;
        this.modDetId = modDetId;
        this.uid = uid;
        this.euid = euid;
    }

    public static RoleDetailsDTO newInstance(final Integer roleId, final Integer modId, final Integer modDetId, final Integer uid, final Integer euid) {
        return new RoleDetailsDTO(roleId, modId, modDetId, uid, euid);
    }
}
