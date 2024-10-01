package com.ponsun.pep.pepDetails.Party.PartyDetails.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.CreatePartyDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.UpdatePartyDetailsRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_party_details")
public class PartyDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "partyCandidateId")
    private Integer partyCandidateId;

    @Column(name = "partyMasterId")
    private Integer partyMasterId;

    @Lob
    @Column(name = "formerAndCurrent",columnDefinition = "TEXT")
    private String formerAndCurrent;

    @Lob
    @Column(name = "positionInTheParty",columnDefinition = "TEXT")
    private String positionInTheParty;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static PartyDetails create(final CreatePartyDetailsRequest createPartyDetailsRequest)
    {
        final PartyDetails partyDetails = new PartyDetails();
        partyDetails.setPepId(createPartyDetailsRequest.getPepId());
        partyDetails.setPartyCandidateId(createPartyDetailsRequest.getPartyCandidateId());
        partyDetails.setPartyMasterId(createPartyDetailsRequest.getPartyMasterId());
        partyDetails.setFormerAndCurrent(createPartyDetailsRequest.getFormerAndCurrent());
        partyDetails.setPositionInTheParty(createPartyDetailsRequest.getPositionInTheParty());
        partyDetails.setUid(createPartyDetailsRequest.getUid());
        partyDetails.onCreate();
        partyDetails.setStatus(Status.ACTIVE);
        return partyDetails;
    }

    public void update(final UpdatePartyDetailsRequest updatePartyDetailsRequest){

        this.setPepId(updatePartyDetailsRequest.getPepId());
        this.setPartyMasterId(updatePartyDetailsRequest.getPartyMasterId());
        this.setPartyCandidateId(updatePartyDetailsRequest.getPartyCandidateId());
        this.setFormerAndCurrent(updatePartyDetailsRequest.getFormerAndCurrent());
        this.setPositionInTheParty(updatePartyDetailsRequest.getPositionInTheParty());
        this.setEuid(updatePartyDetailsRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(final UpdatePartyDetailsRequest updatePartyDetailsRequest){
        this.setStatus(Status.DELETE);
        this.setEuid(updatePartyDetailsRequest.getEuid());
        this.onUpdate();
    }
}

