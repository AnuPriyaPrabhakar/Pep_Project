package com.ponsun.pep.familyDetails.MotherDetails.data;

import lombok.Data;

@Data

public class MotherDetailsData {

    //private Integer id;
    private Integer pepId;
    private String motherName;
    private String motherPan;
    private Integer uid;
    private Integer euid;

    public MotherDetailsData (final Integer pepId,   final String motherName , String motherPan ,  final Integer uid , final Integer euid ) {
        this.pepId = pepId;
        this.motherName = motherName;
        this.motherPan = motherPan;
        this.uid = uid;
        this.euid = euid;
    }
    public static MotherDetailsData newInstance (final Integer pepId,   final String motherName , String motherPan ,  final Integer uid , final Integer euid ) {
        return new MotherDetailsData(pepId,motherName,motherPan,uid,euid);
    }
}
