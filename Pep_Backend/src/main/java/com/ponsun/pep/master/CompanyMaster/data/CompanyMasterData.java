package com.ponsun.pep.master.CompanyMaster.data;

import lombok.Data;

@Data
public class CompanyMasterData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public CompanyMasterData(final Integer id, final String name, final Integer uid, final Integer euid ) {
        this.id=id;
        this.name=name;
        this.uid=uid;
        this.euid=euid;

    }
    public static CompanyMasterData newInstance(final Integer id, final String name , final Integer uid, final Integer euid) {
        return new CompanyMasterData(id,name,uid,euid);
    }
}
