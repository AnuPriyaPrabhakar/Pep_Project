package com.ponsun.pep.spouse.spouseMother.request;

import lombok.Data;

@Data
public class AbstractSpouseMotherRequest {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String motherName;
    private String motherPan;
    private Integer uid;
    private Integer euid;
}
