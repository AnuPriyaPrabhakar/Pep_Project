package com.ponsun.pep.imageDet.request;

import lombok.Data;

@Data
public class AbstractImageDetRequest {
    private Integer id;
    private Integer pepId;
    private String imageName;
    private String file_type;
    private Integer imageMasterId;
    private Integer uid;
    private Integer euid;
}
