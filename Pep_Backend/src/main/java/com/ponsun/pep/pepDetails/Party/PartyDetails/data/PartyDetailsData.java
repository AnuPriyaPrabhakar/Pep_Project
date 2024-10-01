package com.ponsun.pep.pepDetails.Party.PartyDetails.data;

import lombok.Data;

@Data
public class PartyDetailsData {

    private Integer pepId;
    private Integer partyMasterId;
    private String formerAndCurrent;
    private String PositionInTheParty;
    private Integer partyCandidateId;
    private Integer uid;
    private Integer euid;

    public PartyDetailsData (Integer pepId,Integer partyMasterId, String formerAndCurrent,String PositionInTheParty,Integer partyCandidateId, Integer uid, Integer euid) {
        this.pepId = pepId;
        this.partyMasterId = partyMasterId;
        this.formerAndCurrent = formerAndCurrent;
        this.PositionInTheParty = PositionInTheParty;
        this.partyCandidateId = partyCandidateId;
        this.uid = uid;
        this.euid = euid;
    }
    public static PartyDetailsData newInstance (Integer pepId,Integer partyMasterId, String formerAndCurrent,String PositionInTheParty,Integer partyCandidateId ,Integer uid, Integer euid) {
        return new PartyDetailsData(pepId ,partyMasterId,formerAndCurrent,PositionInTheParty,partyCandidateId ,uid,euid);
    }
}
