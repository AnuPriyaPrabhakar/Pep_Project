package com.ponsun.pep.FilesStorage.data;

import lombok.Data;

@Data
public class FileStorageData {

    private Integer id;
    private String companyId;
    private Integer pathId;
    private String documentType;
    private String dt;
    private String url;

    public FileStorageData(final Integer id, final String companyId, final Integer pathId,final String documentType, final String dt, final String url ) {
        this.id=id;
        this.companyId=companyId;
        this.pathId=pathId;
        this.documentType=documentType;
        this.dt=dt;
        this.url=url;
    }
    public static FileStorageData newInstance(final Integer id, final String companyId, final Integer pathId,final String documentType, final String dt, final String url ) {
        return new FileStorageData(id,companyId,pathId,documentType,dt,url);
    }
}

