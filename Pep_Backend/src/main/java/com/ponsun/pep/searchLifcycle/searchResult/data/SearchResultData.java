package com.ponsun.pep.searchLifcycle.searchResult.data;

import lombok.Data;

@Data
public class SearchResultData {
    private Integer id;
    private String name;
    private Double matching_score;
    private Integer listId;
    private Integer typeId;
    private Integer stateId;
    private Integer countryId;
    private String identity;
    private Long levelId;
    private Long uid;
    private Boolean valid;
    private Integer kycId;

    public SearchResultData(final Integer id, final String name, final Double matching_score, final Integer listId, final Integer typeId, final Integer stateId, final Integer countryId, final String identity, final Long levelId, final Long uid , final Boolean valid , final Integer kycId){
        this.id = id;
        this.name = name;
        this.matching_score = matching_score;
        this.listId = listId;
        this.typeId = typeId;
        this.stateId = stateId;
        this.countryId = countryId;
        this.identity = identity;
        this.levelId = levelId;
        this.uid = uid;
        this.valid = valid;
        this.kycId = kycId;
    }

    public static SearchResultData newInstance(final Integer id, final String name, final Double matching_score, final Integer listId, final Integer typeId, final Integer stateId, final Integer countryId, final String identity, final Long levelId, final Long uid , final Boolean valid , final Integer kycId){
        return new SearchResultData(id, name, matching_score, listId, typeId, stateId, countryId, identity, levelId,uid ,valid , kycId);
    }
}
