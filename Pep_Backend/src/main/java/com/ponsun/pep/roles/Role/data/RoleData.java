package com.ponsun.pep.roles.Role.data;
import lombok.Data;

@Data
public class RoleData {
    private String roleName;
    private Integer uid;
    private Integer euid;

    public RoleData (final String roleName , final Integer uid , final Integer euid) {
        this.roleName =  roleName;
        this.uid = uid;
        this.euid = euid;

    }

    public static RoleData newInstance(final String roleName , final Integer uid , final Integer euid) {
        return new RoleData (roleName,uid,euid);
    }
}
