package com.ponsun.pep.pepDetails.Party.PartyDTO.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PartyCandidateDetailsDTO {
    private Integer id;
    private Integer pepId;
    private String otherInformation;
    private String positionInTheGovernment;
    private String died;
    private String permanentAddress;
    private Integer uid;
    private Integer euid;

    public PartyCandidateDetailsDTO(Integer id,Integer pepId,  String otherInformation, String positionInTheGovernment, String died, String permanentAddress, Integer uid, Integer euid) {
        this.id = id;
        this.pepId = pepId;
        this.otherInformation = otherInformation;
        this.positionInTheGovernment = positionInTheGovernment;
        this.died = died;
        this.permanentAddress = permanentAddress;
        this.uid = uid;
        this.euid = euid;
    }
    public static PartyCandidateDetailsDTO newInstance  (Integer id,Integer pepId, String otherInformation, String positionInTheGovernment, String died, String permanentAddress, Integer uid, Integer euid) {
        return new PartyCandidateDetailsDTO(id,pepId ,otherInformation,positionInTheGovernment,died,permanentAddress,uid,euid);
    }
}
