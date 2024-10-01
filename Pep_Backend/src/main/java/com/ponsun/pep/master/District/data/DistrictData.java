package com.ponsun.pep.master.District.data;


import lombok.Data;

@Data
public class DistrictData {
    private String cityName;
    private Integer stateId;
    private Integer countryId;
    private Integer uid;
    private Integer euid;

    public DistrictData (final String cityName , final Integer stateId , final  Integer countryId,final Integer uid,final Integer euid) {
        this.cityName = cityName;
        this.stateId = stateId;
        this.countryId = countryId;
        this.uid = uid;
        this.euid = euid;
    }

    public static DistrictData newInstance (final String cityName , final Integer stateId , final  Integer countryId,final Integer uid,final Integer euid) {
        return new DistrictData(cityName, stateId, countryId,uid,euid);
    }
}
