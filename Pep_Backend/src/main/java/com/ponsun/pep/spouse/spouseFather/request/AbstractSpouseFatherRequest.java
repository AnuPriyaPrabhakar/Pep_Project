package com.ponsun.pep.spouse.spouseFather.request;

import lombok.Data;

@Data
public class AbstractSpouseFatherRequest {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String fatherName;
    private String fatherPan;
    private Integer uid;
    private Integer euid;
}
