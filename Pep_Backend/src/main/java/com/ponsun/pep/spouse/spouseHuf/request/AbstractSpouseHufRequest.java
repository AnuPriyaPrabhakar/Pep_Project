package com.ponsun.pep.spouse.spouseHuf.request;

import lombok.Data;

@Data
public class AbstractSpouseHufRequest {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String hufName;
    private String hufPan;
    private Integer uid;
    private Integer euid;
}
