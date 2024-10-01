package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.data;

import lombok.Data;

@Data
public class DocumentTypeMasterData {
    private String name;
    private Integer uid;
    private Integer euid;

    public DocumentTypeMasterData (final String name , final Integer uid , final Integer euid) {
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }

    public static DocumentTypeMasterData newInstance (final String name  , final Integer uid , final Integer euid) {
        return new DocumentTypeMasterData(name , uid , euid);
    }

}
