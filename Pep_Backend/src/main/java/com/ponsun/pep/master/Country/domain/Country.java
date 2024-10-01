package com.ponsun.pep.master.Country.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.Country.request.CreateCountryRequest;
import com.ponsun.pep.master.Country.request.UpdateCountryRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_country")
public class Country extends BaseEntity {
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


    public static Country create(final CreateCountryRequest createCountryRequest){
        final Country country = new Country();
        country.setName(createCountryRequest.getName());
        country.setUid(createCountryRequest.getUid());
        country.setStatus(Status.ACTIVE);
        country.setCreatedAt(LocalDateTime.now());
        return country;
    }
    public void update(final UpdateCountryRequest updateCountryRequest){
        this.setName(updateCountryRequest.getName());
        this.setEuid(updateCountryRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void deactive(UpdateCountryRequest updateCountryRequest){
        this.setEuid(updateCountryRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }


}

