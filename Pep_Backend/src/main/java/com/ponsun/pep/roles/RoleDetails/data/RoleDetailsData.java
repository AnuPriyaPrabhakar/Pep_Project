package com.ponsun.pep.roles.RoleDetails.data;

import lombok.Data;

@Data
public class RoleDetailsData {
    private Integer id;
    private Integer roleId;
    private Integer modId;
    private Integer modDetId;
    private Integer uid;
    private Integer euid;


    public RoleDetailsData(final Integer id,final Integer roleId,final Integer modId,final Integer modDetId,final Integer uid,final  Integer euid) {
        this.id = id;
        this.roleId = roleId;
        this.modId = modId;
        this.modDetId = modDetId;
        this.uid = uid;
        this.euid = euid;

    }

    public static RoleDetailsData newInstance(final Integer id, final Integer roleId, final Integer modId, final Integer modDetId,final Integer uid,final Integer euid){
        return new RoleDetailsData(id,roleId,modId,modDetId,uid,euid);
    }

}
