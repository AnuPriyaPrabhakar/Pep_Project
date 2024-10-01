package com.ponsun.pep.RequestDescription.data;

import lombok.Data;

@Data
public class RequestDescriptionData {
    private Integer id;
    private Integer pepId;
    private String description;
    private Integer uid;
    public RequestDescriptionData(final Integer id,final Integer pepId,final String description,final Integer uid ){
        this.id= id;
        this.pepId = pepId;
        this.description = description;
        this.uid = uid;
    }
    public static  RequestDescriptionData newInstance(final Integer id,final  Integer pepId,final String description,final Integer uid){
        return new RequestDescriptionData(id,pepId,description,uid);
    }
}

