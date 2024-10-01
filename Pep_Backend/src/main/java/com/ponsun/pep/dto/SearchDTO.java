package com.ponsun.pep.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class SearchDTO {
    private String name;
    private double matching_score;
    private int listID;
    private int partySubTypeID;
    private int countryId;
    private int uid;


    public SearchDTO(String name,double matching_score,int listID,int partySubTypeID,int countryId,int uid){
        this.name = name;
        this.matching_score = matching_score;
        this.listID = listID;
        this.partySubTypeID = partySubTypeID;
        this.countryId = countryId;
        this.uid = uid;
    }
    public static SearchDTO newInstance(String name,double matching_score,int listID,int partySubTypeID,int countryId,int uid){
      return new SearchDTO(name,matching_score,listID,partySubTypeID,countryId,uid);
    }
}
