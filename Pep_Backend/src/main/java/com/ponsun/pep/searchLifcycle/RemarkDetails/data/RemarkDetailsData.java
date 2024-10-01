package com.ponsun.pep.searchLifcycle.RemarkDetails.data;

import lombok.Data;

@Data

public class RemarkDetailsData {
    private Integer levelId;
//    private Integer hitdataId;
    private String remark;
    private String createdAt;

    public RemarkDetailsData(final Integer levelId,final String remark,final String createdAt){
        this.levelId = levelId;
//        this.hitdataId = hitdataId;
        this.remark = remark;
        this.createdAt = createdAt;
    }
    public static RemarkDetailsData newInstance(final Integer levelId,final String remark,final String createdAt){
        return new RemarkDetailsData(levelId,remark,createdAt);
    }
}
