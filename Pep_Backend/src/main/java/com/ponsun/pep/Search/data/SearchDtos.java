package com.ponsun.pep.Search.data;

import com.ponsun.pep.searchDetails.data.SearchDetailsData;
import lombok.Data;

import java.util.List;

@Data
public class SearchDtos {
    private Integer id;
    private String name;
    private String searchingScore;
    private Integer uid;
    private Integer euid;
    private String fromDate;
    private String toDate;
    private List<SearchDetailsData>searchDetailsData;

    public SearchDtos(Integer id, String name, String searchingScore, Integer uid, Integer euid, String fromDate, String toDate, List<SearchDetailsData> searchDetailsData) {
        this.id = id;
        this.name = name;
        this.searchingScore = searchingScore;
        this.uid = uid;
        this.euid = euid;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.searchDetailsData = searchDetailsData;
    }

    public SearchDtos() {

    }

    public static SearchDtos newInstance(Integer id, String name, String searchingScore, Integer uid, Integer euid, String fromDate, String toDate, List<SearchDetailsData> searchDetailsData){
        return new SearchDtos(id,name,searchingScore,uid,euid,fromDate,toDate,searchDetailsData);
    }
}
