package com.ponsun.pep.category.data;

import lombok.Data;
@Data
public class CategoryData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public CategoryData(final Integer id, final String name,final Integer uid,final Integer euid ) {
        this.id=id;
        this.name=name;
        this.uid=uid;
        this.euid=euid;
    }
    public static CategoryData newInstance(final Integer id, final String name , final Integer uid, final Integer euid) {
        return new CategoryData(id,name,uid,euid);
    }
}
