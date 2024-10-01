package com.ponsun.pep.master.State.data;

import lombok.Data;
@Data
public class StateData {
    private Integer id;
    private Integer countryId;
    private String stateName;
    private Integer uid;
    private Integer euid;
    public StateData(final Integer id,final Integer countryId,final String stateName,final Integer uid,final Integer euid){
        this.id = id;
        this.countryId = countryId;
        this.stateName = stateName;
        this.uid = uid;
        this.euid = euid;
    }
    public static StateData newInstance (final Integer id,final Integer countryId,final String stateName,final Integer uid,final Integer euid){
      return new StateData(id,countryId,stateName,uid,euid);
    }
}
