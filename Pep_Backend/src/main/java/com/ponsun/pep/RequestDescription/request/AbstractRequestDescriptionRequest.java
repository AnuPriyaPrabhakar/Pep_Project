package com.ponsun.pep.RequestDescription.request;

import lombok.Data;

@Data
public class AbstractRequestDescriptionRequest {
    private Integer id;
    private Integer pepId;
    private String description;
    private Integer uid;
}
