package com.ponsun.pep.pepIdentitfier.Indentitfier.data;
import lombok.Data;

@Data
public class IdentifierData {

    private Integer pepId;
    private String name;
    private String pepName;
    private String identity;
    private String who;
    private String sourceLink;
    private String dob;

    public  IdentifierData (final Integer pepId , final String name , final String pepName , final String identity , final String who ,final String sourceLink , final String dob ) {

        this.pepId = pepId;
        this.name = name;
        this.pepName = pepName;
        this.identity = identity;
        this.who = who;
        this.sourceLink = sourceLink;
        this.dob = dob;

    }
    public static IdentifierData newInstance (final Integer pepId , final String name , final String pepName , final String identity , final String who ,final String sourceLink , final String dob ) {
        return new IdentifierData(pepId,name,pepName,identity,who,sourceLink,dob);
    }
}
