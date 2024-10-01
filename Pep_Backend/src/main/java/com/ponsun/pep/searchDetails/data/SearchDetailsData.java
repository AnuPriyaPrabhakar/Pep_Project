//package com.ponsun.pep.searchDetails.data;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@Data
//@RequiredArgsConstructor
//public class SearchDetailsData {
//    private Integer id;
//    private Integer searchId;
//    private String name;
//    private Double matchingScore;
//    private Integer uid;
//    private Integer euid;
//    private String fromDate;
//    private String toDate;
//    private Integer kycId;
//    public SearchDetailsData(Integer id,Integer searchId,String name,Double matchingScore,Integer uid,Integer euid,final String fromDate , final String toDate , final Integer kycId){
//        this.id = id;
//        this.searchId = searchId;
//        this.name = name;
//        this.matchingScore = matchingScore;
//        this.uid = uid;
//        this.euid = euid;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
//        this.kycId = kycId;
//    }
//
//
//    public static SearchDetailsData newInstance(Integer id,Integer searchId,String name,Double matchingScore,Integer uid,Integer euid,final String fromDate , final String toDate, final Integer kycId){
//        return new SearchDetailsData(id,searchId,name,matchingScore,uid,euid,fromDate , toDate,kycId);
//    }
//}

package com.ponsun.pep.searchDetails.data;

import lombok.Data;

@Data
public class SearchDetailsData {
    private Integer id;
    private Integer euid;
    private Integer searchId;
    private Integer countryId;
    private String identity;
    private Long levelId;
    private Integer listId;
    private Double matchingScore;
    private String name;
    private Integer stateId;
    private Integer typeId;
    private Integer uid;
    private Boolean valid;
    private Integer kycId;

    public SearchDetailsData(final Integer id,final Integer euid,final Integer searchId,final Integer countryId,final String identity,final Long levelId,final Integer listId,final Double matchingScore,final String name,final Integer stateId,final Integer typeId,final Integer uid,final Boolean valid,final Integer kycId){
        this.id = id;
        this.euid= euid;
        this.searchId = searchId;
        this.countryId = countryId;
        this.identity = identity;
        this.levelId = levelId;
        this.listId = listId;
        this.matchingScore = matchingScore;
        this.name = name;
        this.stateId = stateId;
        this.typeId = typeId;
        this.uid = uid;
        this.valid = valid;
        this.kycId = kycId;
    }
    public static SearchDetailsData newInstance(final Integer id,final Integer euid,final Integer searchId,final Integer countryId,final String identity,final Long levelId,final Integer listId,final Double matchingScore,final String name,final Integer stateId,final Integer typeId,final Integer uid,final Boolean valid,final Integer kycId){
        return new SearchDetailsData(id,euid,searchId,countryId,identity,levelId,listId,matchingScore,name,stateId,typeId,uid,valid,kycId);
    }
}

