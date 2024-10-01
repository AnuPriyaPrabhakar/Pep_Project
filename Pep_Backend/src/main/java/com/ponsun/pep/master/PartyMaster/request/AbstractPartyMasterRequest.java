package com.ponsun.pep.master.PartyMaster.request;

import lombok.Data;

@Data
public class AbstractPartyMasterRequest {
    private String partyName;
    private Integer uid;
    private Integer euid;
}
