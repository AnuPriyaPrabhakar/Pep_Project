package com.ponsun.pep.category.request;

import lombok.Data;

@Data
public class AbstractCategoryRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
