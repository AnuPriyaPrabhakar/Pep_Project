package com.ponsun.pep.Search.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class SearchDTO {
    private String name;
    private double matching_score;
    private Integer uid;

    public SearchDTO(String name, double matching_score,Integer uid) {
        this.name = name;
        this.matching_score = matching_score;
        this.uid=uid;
    }
    public static SearchDTO newInstance(String name, double matching_score,Integer uid){
        return new SearchDTO(name,matching_score,uid);
    }
}
