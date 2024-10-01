package com.ponsun.pep.master.designation.request;

import lombok.Data;

@Data
public class AbstractDesignationRequest {
//    private Integer id;
    private String name;
    private String dt;
    private Boolean valid;
}
