package com.ponsun.pep.searchLifcycle.rif.data;

import lombok.Data;

@Data
public class LevelFourData {
    private Integer searchId;
//    private Integer criminalId;
    private Integer hitId;
    private Integer caseId;
    private String name;
    private Integer matchScore;
    private String country;
    private String state;
    private String searchName;
//    private String dob;
//    private Integer levelId;

    public LevelFourData(final Integer searchId,final Integer hitId,final Integer caseId,final String name,final Integer matchScore,final String country,final String state , final String searchName){
        this.searchId = searchId;
//        this.criminalId = criminalId;
        this.hitId = hitId;
        this.caseId = caseId;
        this.name = name;
        this.matchScore = matchScore;
        this.country = country;
        this.state = state;
        this.searchName = searchName;
//        this.dob = dob;
        //this.levelId = levelId;
    }

    public static  LevelFourData newInstance(final Integer searchId,final Integer hitId,final Integer caseId,final String name,final Integer matchScore,final String country,final String state , final String searchName){
        return new LevelFourData(searchId, hitId, caseId, name, matchScore, country, state , searchName);
    }
}
