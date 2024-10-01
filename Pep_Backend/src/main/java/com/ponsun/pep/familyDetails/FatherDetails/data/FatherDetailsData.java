package com.ponsun.pep.familyDetails.FatherDetails.data;


import lombok.Data;

@Data
public class FatherDetailsData {
    private Integer pepId;
    private String fatherName;
    private String fatherPan;
    private Integer uid;
    private Integer euid;

    public FatherDetailsData (final Integer pepId,  final String fatherName , final String fatherPan , final Integer uid , final Integer euid ) {
        this.pepId = pepId;
        this.fatherName = fatherName;
        this.fatherPan = fatherPan;
        this.uid = uid;
        this.euid = euid;
    }
    public static FatherDetailsData newInstance (final Integer pepId, final String fatherName , final String fatherPan , final Integer uid , final Integer euid ) {
        return new FatherDetailsData(pepId,fatherName,fatherPan,uid,euid);
    }
}
