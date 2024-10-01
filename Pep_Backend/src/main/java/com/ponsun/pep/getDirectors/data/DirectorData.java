package com.ponsun.pep.getDirectors.data;

import lombok.Data;

@Data
public class DirectorData {
    private Integer id;
    private String name;
    private String pan;
    private Integer uid;
    private Integer euid;

    public DirectorData (Integer id, String name ,  String pan , Integer uid , Integer euid) {
        this.id = id;
        this.name = name;
        this.pan = pan;
        this.uid = uid;
        this.euid = euid;
    }
    public static  DirectorData newInstance (Integer id, String name , String pan , Integer uid , Integer euid) {
        return new DirectorData(id,name, pan , uid , euid);
    }
}
