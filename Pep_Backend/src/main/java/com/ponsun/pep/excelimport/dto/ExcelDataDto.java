package com.ponsun.pep.excelimport.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor

public class ExcelDataDto {
    private String name;
    private double score;
    private String type;
    private String country;
    public ExcelDataDto (String name,double score,String type,String country) {
        this.name = name;
        this.score=score;
        this.type=type;
        this.country=country;
    }

    public static ExcelDataDto newInstance (String name,double score,String type,String country){
        return new ExcelDataDto(name,score,type,country);
    }
}

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getScore() {
//        return score;
//    }
//
//    public void setScore(Double score) {
//        this.score = score;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }