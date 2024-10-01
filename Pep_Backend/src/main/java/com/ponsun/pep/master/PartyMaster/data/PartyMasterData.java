package com.ponsun.pep.master.PartyMaster.data;

import lombok.Data;

@Data
public class PartyMasterData {
    private String partyName;
    private Integer uid;
    private Integer euid;

    public  PartyMasterData (final String partyName , Integer uid, Integer euid ) {
        this.partyName = partyName;
        this.uid = uid;
        this.euid = euid;
    }

    public static PartyMasterData newInstance (final String partyName , Integer uid, Integer euid ) {
        return new PartyMasterData(partyName, uid, euid);
    }
}
