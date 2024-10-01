package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data;

import lombok.Data;

@Data
public class PartyReadData {
    private Integer id;
    private Integer pepId;
    private String formerAndCurrent;
    private Integer stateId;
    private Integer countryId;
    private String otherInformation;
    private String PositionInTheParty;
    private String positionInTheGovernment;
    private String died;
    private String permanentAddress;
    private Integer uid;
    private Integer euid;

    public PartyReadData(Integer id , Integer pepId, String formerAndCurrent, Integer stateId, Integer countryId, String otherInformation, String PositionInTheParty,String positionInTheGovernment, String died, String permanentAddress, Integer uid, Integer euid) {
        this.id = id;
        this.pepId = pepId;
        this.formerAndCurrent = formerAndCurrent;
        this.stateId = stateId;
        this.countryId = countryId;
        this.PositionInTheParty = PositionInTheParty;
        this.positionInTheGovernment = positionInTheGovernment;
        this.otherInformation = otherInformation;
        this.died = died;
        this.permanentAddress = permanentAddress;
        this.uid = uid;
        this.euid = euid;
    }
    public static PartyReadData newInstance(Integer id ,Integer pepId, String formerAndCurrent, Integer stateId, Integer countryId, String otherInformation,String PositionInTheParty, String positionInTheGovernment,String died, String permanentAddress, Integer uid, Integer euid) {
        return new PartyReadData(id ,pepId ,formerAndCurrent ,stateId ,countryId ,otherInformation,PositionInTheParty,positionInTheGovernment,died,permanentAddress,uid,euid);
    }
}
