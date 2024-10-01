package com.ponsun.pep.master.District.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.District.request.CreateDistrictRequest;
import com.ponsun.pep.master.District.request.UpdateDistrictRequest;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "pep_config_district")
public class District extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "stateId")
    private Integer stateId;

    @Column(name = "countryId")
    private Integer countryId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static District create(CreateDistrictRequest createDistrictRequest) {
        final District district = new District();
        district.setCityName(createDistrictRequest.getCityName());
        district.setStateId(createDistrictRequest.getStateId());
        district.setCountryId(createDistrictRequest.getCountryId());
        district.setUid(createDistrictRequest.getUid());
        district.onCreate();
        district.setStatus(Status.ACTIVE);
        return district;
    }
    public void update(UpdateDistrictRequest updateDistrictRequest) {
        this.setCityName(updateDistrictRequest.getCityName());
        this.setStateId(updateDistrictRequest.getStateId());
        this.setCountryId(updateDistrictRequest.getCountryId());
        this.setEuid(updateDistrictRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);

    }

    public void deactive(UpdateDistrictRequest updateDistrictRequest){
        this.setEuid(updateDistrictRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }

}

