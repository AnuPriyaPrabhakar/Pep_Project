package com.ponsun.pep.spouse.spouseDetails.request;

import lombok.Data;

@Data
public class AbstractSpouseDetailsRequest {
    private Integer id;
    private Integer pepId;
    private Integer hufId;
    private String spouseName;
    private String spousePan;
    private Integer uid;
    private Integer euid;
}
