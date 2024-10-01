package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_party_candidate_details")
public class PartyCandidateDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Lob
    @Column(name = "otherInformation",columnDefinition = "TEXT")
    private String otherInformation;

    @Lob
    @Column(name = "positionInTheGovernment",columnDefinition = "TEXT")
    private String positionInTheGovernment;

    @Column(name = "died")
    private String died;

    @Lob
    @Column(name = "permanentAddress",columnDefinition = "TEXT")
    private String permanentAddress;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static PartyCandidateDetails create(final CreatePartyCandidateDetailsRequest createPartyCandidateDetailsRequest)
    {
        final PartyCandidateDetails partyCandidateDetails = new PartyCandidateDetails();
        partyCandidateDetails.setPepId(createPartyCandidateDetailsRequest.getPepId());
        partyCandidateDetails.setOtherInformation(createPartyCandidateDetailsRequest.getOtherInformation());
        partyCandidateDetails.setPositionInTheGovernment(createPartyCandidateDetailsRequest.getPositionInTheGovernment());
        partyCandidateDetails.setDied(createPartyCandidateDetailsRequest.getDied());
        partyCandidateDetails.setPermanentAddress(createPartyCandidateDetailsRequest.getPermanentAddress());
        partyCandidateDetails.setUid(createPartyCandidateDetailsRequest.getUid());
        partyCandidateDetails.onCreate();
        partyCandidateDetails.setStatus(Status.ACTIVE);
        return partyCandidateDetails;
    }
}

