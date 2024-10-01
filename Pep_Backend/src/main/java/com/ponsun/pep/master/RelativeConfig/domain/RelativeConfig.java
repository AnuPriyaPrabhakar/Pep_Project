package com.ponsun.pep.master.RelativeConfig.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.RelativeConfig.request.CreateRelativeRequest;
import com.ponsun.pep.master.RelativeConfig.request.UpdateRelativeRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_relative")
public class RelativeConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static RelativeConfig create(final CreateRelativeRequest createRelativeRequest)
    {
        final RelativeConfig relativeConfig = new RelativeConfig();
        relativeConfig.setName(createRelativeRequest.getName());
        relativeConfig.setUid(createRelativeRequest.getUid());
        relativeConfig.onCreate();
        relativeConfig.setStatus(Status.ACTIVE);
        return relativeConfig;
    }
    public void update(final UpdateRelativeRequest updateRelativeRequest){
        this.setName(updateRelativeRequest.getName());
        this.setEuid(updateRelativeRequest.getEuid());
        this.setStatus(Status.ACTIVE); // Set a default status value here
        this.onUpdate();
        //this.setValid(updateCountryRequest.getValid());
    }

    public void deactive(final UpdateRelativeRequest updateRelativeRequest){
        this.setEuid(updateRelativeRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }
}

