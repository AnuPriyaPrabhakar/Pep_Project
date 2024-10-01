package com.ponsun.pep.FilesStorage.request;

import lombok.Data;

@Data
public class AbstractFileStorageRequest {

    private Integer id;
    private String name;
    private String dt;
    private String url;
}
