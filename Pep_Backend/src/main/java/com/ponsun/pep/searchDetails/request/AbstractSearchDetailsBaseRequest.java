package com.ponsun.pep.searchDetails.request;

import lombok.Data;

@Data
public abstract class AbstractSearchDetailsBaseRequest {
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
    private Integer applicantId;


}
