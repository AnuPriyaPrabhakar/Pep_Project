package com.ponsun.pep.dinEdit.data;

import lombok.Data;

@Data
public class DinEditData {
    private Integer id;
    private String name;
    private String din;
    private Integer uid;

    public DinEditData(final Integer id,final String name,final String din,final Integer uid){
        this.id = id;
        this.name = name;
        this.din = din;
        this.uid = uid;
    }
    public static DinEditData newInstance(final Integer id,final String name,final String din,final Integer uid){
        return new DinEditData(id,name,din,uid);
    }
}
