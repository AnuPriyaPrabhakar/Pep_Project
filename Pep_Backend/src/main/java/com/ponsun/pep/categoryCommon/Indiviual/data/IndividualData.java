package com.ponsun.pep.categoryCommon.Indiviual.data;

import lombok.Data;

@Data
public class IndividualData {
    private Integer pepId;
    private String userName;
    private String pepName;
    private String SourceLink;
    private String Education;
    private String PepPan;
    private String PepDob;

    public IndividualData (final Integer pepId , String userName, final String pepName , final String SourceLink ,final String Education,String PepPan,String PepDob) {
        this.pepId = pepId;
        this.userName = userName;
        this.pepName = pepName;
        this.SourceLink = SourceLink;
        this.Education = Education;
        this.PepPan = PepPan;
        this.PepDob = PepDob;
    }

    public static IndividualData newInstance (final Integer pepId ,final String userName, final String pepName , final String SourceLink ,final String Education,String PepPan,String PepDob) {
        return new IndividualData(pepId,userName, pepName, SourceLink, Education, PepPan, PepDob);
    }
}
