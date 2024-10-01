package com.ponsun.pep.pepDetails.ContactsDetails.data;

import lombok.Data;

@Data
public class ContactsDetailsData {
    private Integer id;
    private Integer pepId;
    private String communicationDt;
    private Integer communicationTypeId;
    private Integer uid;
    private Integer euid;

    public ContactsDetailsData(final Integer id, final Integer pepId,  final String communicationDt,final Integer communicationTypeId,final Integer uid,final Integer euid){
        this.id = id;
        this.pepId = pepId;
        this.communicationDt = communicationDt;
        this.communicationTypeId = communicationTypeId;
        this.uid = uid;
        this.euid = euid;
    }
    public static ContactsDetailsData newInstance(final Integer id, final Integer pepId, final String communicationDt,final Integer communicationTypeId,final Integer uid,final Integer euid){
        return new ContactsDetailsData(id,pepId,communicationDt,communicationTypeId,uid,euid);
    }
}
