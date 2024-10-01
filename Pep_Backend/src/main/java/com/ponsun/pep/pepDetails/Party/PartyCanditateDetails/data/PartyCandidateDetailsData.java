package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data;
import lombok.Data;

@Data
public class PartyCandidateDetailsData {
    private Integer id;
    private Integer pepId;
    private String otherInformation;
    private String positionInTheGovernment;
    private String died;
    private String permanentAddress;
    private Integer uid;
    private Integer euid;

    public PartyCandidateDetailsData(Integer id,Integer pepId,  String otherInformation, String positionInTheGovernment, String died, String permanentAddress, Integer uid, Integer euid) {
        this.id = id;
        this.pepId = pepId;
        this.otherInformation = otherInformation;
        this.positionInTheGovernment = positionInTheGovernment;
        this.died = died;
        this.permanentAddress = permanentAddress;
        this.uid = uid;
        this.euid = euid;
    }
    public static PartyCandidateDetailsData newInstance  (Integer id,Integer pepId, String otherInformation, String positionInTheGovernment, String died, String permanentAddress, Integer uid, Integer euid) {
        return new PartyCandidateDetailsData( id,pepId ,otherInformation,positionInTheGovernment,died,permanentAddress,uid,euid);
    }
}
