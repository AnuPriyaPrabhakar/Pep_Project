package com.ponsun.pep.master.State.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.State.request.CreateStateRequest;
import com.ponsun.pep.master.State.request.UpdateStateRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_state")
public class State extends BaseEntity {
    private static final long serialVersionUID =1L;

    @Id
    @Column(name ="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="countryId")
    private Integer countryId;

    @Column(name="stateName")
    private String stateName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static State create(final CreateStateRequest createStateRequest){
        final State state = new State();
        state.setCountryId(createStateRequest.getCountryId());
        state.setStateName(createStateRequest.getStateName());
        state.setUid(createStateRequest.getUid());
        state.onCreate();
        state.setStatus(Status.ACTIVE);
        return state;
    }
    public void update(UpdateStateRequest updateStateRequest){
        this.setCountryId(updateStateRequest.getCountryId());
        this.setStateName(updateStateRequest.getStateName());
        this.setEuid(updateStateRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
    public void deactive(UpdateStateRequest updateStateRequest){
        this.setEuid(updateStateRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }
}
