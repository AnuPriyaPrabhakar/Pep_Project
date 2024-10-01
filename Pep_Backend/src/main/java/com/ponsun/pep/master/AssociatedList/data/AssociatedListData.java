package com.ponsun.pep.master.AssociatedList.data;

import lombok.Data;

@Data
public class AssociatedListData {
    private Integer id;
    private String name;


    public AssociatedListData(final Integer id,  final String name) {
        this.id = id;
        this.name = name;
   }
    public static AssociatedListData newInstance(final Integer id,  final String name){
        return new AssociatedListData(id,name);
    }
}
