package com.ponsun.pep.pepDetails.Party.PartyDetails.request;

import lombok.Data;

@Data
public class AbstractPartyDetailsRequest {

    private Integer pepId;
    private Integer partyMasterId;
    private String formerAndCurrent;
    private String positionInTheParty;
    private Integer partyCandidateId;
    private Integer uid;
    private Integer euid;
}
