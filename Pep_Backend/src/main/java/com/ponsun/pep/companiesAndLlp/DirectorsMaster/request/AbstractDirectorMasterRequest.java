package com.ponsun.pep.companiesAndLlp.DirectorsMaster.request;

import lombok.Data;

@Data
public class AbstractDirectorMasterRequest {
    private String name;
    private String din;
    private Integer uid;
    private Integer euid;
}
