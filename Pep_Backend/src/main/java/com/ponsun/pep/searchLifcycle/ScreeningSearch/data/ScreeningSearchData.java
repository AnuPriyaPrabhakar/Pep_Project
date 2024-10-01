package com.ponsun.pep.searchLifcycle.ScreeningSearch.data;

import lombok.Data;

@Data
public class ScreeningSearchData {
    private Integer id;
    private String name;
    private Integer kycId;

    public ScreeningSearchData(final Integer id,final String name,final Integer kycId){
        this.id = id;
        this.name = name;
        this.kycId = kycId;
    }
    public static ScreeningSearchData newInstance(final Integer id,final String name,final Integer kycId){
        return new ScreeningSearchData(id,name,kycId);
    }

}
