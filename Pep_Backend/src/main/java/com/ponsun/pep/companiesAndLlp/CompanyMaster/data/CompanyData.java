package com.ponsun.pep.companiesAndLlp.CompanyMaster.data;

import lombok.Data;

@Data
public class CompanyData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public CompanyData(final Integer id, final String name,final Integer uid,final Integer euid ) {
        this.id=id;
        this.name=name;
        this.uid=uid;
        this.euid=euid;

    }
    public static CompanyData newInstance(final Integer id, final String name , final Integer uid, final Integer euid) {
        return new CompanyData(id,name,uid,euid);
    }
}
