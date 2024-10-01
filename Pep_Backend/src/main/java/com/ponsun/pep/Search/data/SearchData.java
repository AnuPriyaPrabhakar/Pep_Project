package com.ponsun.pep.Search.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchData {
    private Integer id;
    private String name;
    private String searchingScore;
    private double matching_score;
    private Integer uid;
    private Integer euid;
    private String userName;
    private LocalDateTime created_at;
    private String fromDate;
    private String toDate;

    public SearchData(Integer id, String name, String searchingScore,final double matching_score, Integer uid, Integer euid,String userName, final LocalDateTime created_at, final String fromDate , final String toDate) {
        this.id = id;
        this.name = name;
        this.searchingScore = searchingScore;
        this.matching_score = matching_score;
        this.uid = uid;
        this.euid = euid;
        this.created_at = created_at;
        this.userName = userName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static SearchData newInstance(Integer id, String name, String searchingScore,final double matching_score, Integer uid, Integer euid,String userName, final LocalDateTime created_at, final String fromDate , final String toDate) {
        return new SearchData(id, name, searchingScore,matching_score, uid,euid,userName,created_at,fromDate , toDate);
    }
}
