package com.ponsun.pep.searchLifcycle.searchResult.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AbstractSearchResultBaseRequest {
    private String name;
    private Double matching_score;
    private Double searchingScore;
    private Integer listId;
    private Integer typeId;
    private Integer stateId;
    private Integer countryId;
    private String identity;
    private Long levelId;
    private LocalDateTime dt;
    private Long uid;
    private Boolean valid;
    private Integer kycId;
    private Integer applicantFormId;
    private Integer screeningType;
    private Integer isScreening;
}
