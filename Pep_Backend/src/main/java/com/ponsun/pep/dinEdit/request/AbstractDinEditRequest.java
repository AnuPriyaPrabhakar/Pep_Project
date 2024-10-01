package com.ponsun.pep.dinEdit.request;

import lombok.Data;

@Data
public class AbstractDinEditRequest {
    private String name;
    private String din;
    private Integer uid;
    private Integer euid;
}
