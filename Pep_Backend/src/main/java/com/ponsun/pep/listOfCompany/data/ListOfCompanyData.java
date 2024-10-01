package com.ponsun.pep.listOfCompany.data;

import lombok.Data;

@Data
public class ListOfCompanyData {
    private Integer id;
    private String type;
    private Integer uid;
    private Integer euid;

    public ListOfCompanyData(final Integer id,final String type,final Integer uid,final Integer euid){
        this.id = id;
        this.type = type;
        this.uid = uid;
        this.euid = euid;
    }
    public static ListOfCompanyData newInstance(final Integer id,final String type,final Integer uid,final Integer euid){
        return new ListOfCompanyData(id,type,uid,euid);
    }

}
