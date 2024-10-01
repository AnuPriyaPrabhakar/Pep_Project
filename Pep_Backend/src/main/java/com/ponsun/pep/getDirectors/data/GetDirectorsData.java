package com.ponsun.pep.getDirectors.data;

import lombok.Data;

@Data
public class GetDirectorsData {

    private Integer directorId;
    private String name;
    private String din;
    private String directorsIdentificationNumber;
    private String pan;

    public GetDirectorsData (Integer directorId, String name , String din , String directorsIdentificationNumber , String pan) {
        this.directorId = directorId;
        this.name = name;
        this.din = din;
        this.directorsIdentificationNumber = directorsIdentificationNumber;
        this.pan = pan;
    }
    public static  GetDirectorsData newInstance (Integer directorId, String name , String din , String directorsIdentificationNumber , String pan) {
        return new GetDirectorsData(directorId,name, din, directorsIdentificationNumber, pan);
    }
}
