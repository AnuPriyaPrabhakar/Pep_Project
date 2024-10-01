package com.ponsun.pep.searchLifcycle.screeningRecord.data;

import lombok.Data;

@Data
public class ScreeningRecordData {
    private Integer id;
    private String name;

    public ScreeningRecordData(final Integer id,final String name){
        this.id = id;
        this.name = name;
    }
    public static ScreeningRecordData newInstance(final Integer id,final String name){
        return new ScreeningRecordData(id,name);
    }
}
