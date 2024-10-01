package com.ponsun.pep.pepDetails.Party.PartyDTO.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PartyDetailsDTO {

    private Integer pepId;
    private Integer partyMasterId;
    private String formerAndCurrent;
    private String positionInTheParty;
    private Integer partyCandidateId;
    private Integer uid;
    private Integer euid;

    public PartyDetailsDTO(Integer pepId, Integer partyMasterId, String formerAndCurrent, String positionInTheParty, Integer partyCandidateId, Integer uid, Integer euid) {
        this.pepId = pepId;
        this.partyMasterId = partyMasterId;
        this.formerAndCurrent = formerAndCurrent;
        this.positionInTheParty = positionInTheParty;
        this.partyCandidateId = partyCandidateId;
        this.uid = uid;
        this.euid = euid;
    }

    public static PartyDetailsDTO newInstance(Integer pepId, Integer partyMasterId, String formerAndCurrent, String positionInTheParty, Integer partyCandidateId, Integer uid, Integer euid) {
        return new PartyDetailsDTO(pepId, partyMasterId, formerAndCurrent, positionInTheParty, partyCandidateId, uid, euid);
    }
}
