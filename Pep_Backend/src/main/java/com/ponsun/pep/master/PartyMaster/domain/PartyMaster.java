package com.ponsun.pep.master.PartyMaster.domain;

import com.ponsun.pep.master.PartyMaster.request.CreatePartyMasterRequest;
import com.ponsun.pep.master.PartyMaster.request.UpdatePartyMasterRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
//@Accessors(chain = true)
@Table(name = "pep_config_party")

public class PartyMaster extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "partyName")
    private String partyName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static PartyMaster create(final CreatePartyMasterRequest createPartyMasterRequest) {
        final PartyMaster partyMaster = new PartyMaster();
        partyMaster.setPartyName(createPartyMasterRequest.getPartyName());
        partyMaster.setUid(createPartyMasterRequest.getUid());
        partyMaster.onCreate();
        partyMaster.setStatus(Status.ACTIVE);
        return partyMaster;
    }

    public void update(UpdatePartyMasterRequest updatePartyMasterRequest) {
        this.setPartyName(updatePartyMasterRequest.getPartyName());
        this.setEuid(updatePartyMasterRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdatePartyMasterRequest updatePartyMasterRequest) {
        this.setEuid(updatePartyMasterRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }
}