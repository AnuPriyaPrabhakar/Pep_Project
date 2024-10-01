package com.ponsun.pep.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ScreenDTO {
    private String name;
    private double searchingScore;
    private Integer uid;
    private Integer kycId;
    private Integer applicantFormId;
    private Integer screeningType;
    private Integer isScreening;
    private ScreenDTO(String name,double searchingScore,Integer uid,Integer kycId , Integer applicantFormId , Integer screeningType , Integer isScreening){
        this.name = name;
        this.searchingScore = searchingScore;
        this.uid = uid;
        this.kycId = kycId;
        this.applicantFormId = applicantFormId;
        this.screeningType = screeningType;
        this.isScreening = isScreening;
    }
    public static ScreenDTO newInstance(String name,double searchingScore,Integer uid,Integer kycId , Integer applicantFormId , Integer screeningType , Integer isScreening){
        return  new ScreenDTO(name,searchingScore,uid,kycId,applicantFormId,screeningType,isScreening);
    }
}
