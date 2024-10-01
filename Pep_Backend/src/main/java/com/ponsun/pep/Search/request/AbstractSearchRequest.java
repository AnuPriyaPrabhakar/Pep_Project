package com.ponsun.pep.Search.request;

import lombok.Data;

@Data
public class AbstractSearchRequest {
    private Integer id;
    private String name;
    private String searchingScore;
    private Integer uid;
    private Integer euid;
    private Integer applicantFormId;
}
