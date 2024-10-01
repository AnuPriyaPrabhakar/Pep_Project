package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request;

import lombok.Data;

@Data
public class AbstractPartyCandidateDetailsRequest {
    private Integer id;
    private Integer pepId;
    private Integer partyDetailsId;
    private String otherInformation;
    private String positionInTheGovernment;
    private String died;
    private String permanentAddress;
    private Integer uid;
    private Integer euid;
}


