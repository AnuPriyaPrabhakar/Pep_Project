package com.ponsun.pep.master.status.request;

import lombok.Data;

@Data
public class AbstractStatusBaseRequest {
//    private Integer id;
    private String code;
    private String name;
    private Boolean valid;
}
