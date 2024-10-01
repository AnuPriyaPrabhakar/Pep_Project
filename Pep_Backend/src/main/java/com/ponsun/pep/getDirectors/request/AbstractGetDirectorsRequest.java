package com.ponsun.pep.getDirectors.request;

import lombok.Data;

@Data
public class AbstractGetDirectorsRequest {
    private Integer id;
    private String name;
    private String pan;
    private Integer uid;
    private Integer euid;
}
