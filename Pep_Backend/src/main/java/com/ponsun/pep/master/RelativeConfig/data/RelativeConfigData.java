package com.ponsun.pep.master.RelativeConfig.data;

import lombok.Data;

@Data
public class RelativeConfigData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public RelativeConfigData(final Integer id, final String name,  final Integer uid,final  Integer euid) {
        this.id=id;
        this.name=name;
        this.uid = uid;
        this.euid = euid;
    }
    public static RelativeConfigData newInstance(final Integer id, final String name, final Integer uid,final Integer euid) {
        return new RelativeConfigData(id,name,uid,euid);
    }
}