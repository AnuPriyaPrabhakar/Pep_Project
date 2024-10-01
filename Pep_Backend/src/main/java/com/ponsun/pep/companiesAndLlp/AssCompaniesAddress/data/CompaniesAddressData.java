package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.data;

import lombok.Data;

@Data
public class CompaniesAddressData {
    private Integer id;
    private Integer companyId;
    private String registeredAddress;
    private Integer uid;
    private Integer euid;

    public CompaniesAddressData (final Integer id, final Integer companyId,final String registeredAddress , final Integer uid,final Integer euid){
        this.id = id;
        this.companyId = companyId;
        this.registeredAddress = registeredAddress;
        this.uid = uid;
        this.euid = euid;
    }
    public static CompaniesAddressData newInstance (final Integer id, final Integer companyId,final String registeredAddress , final Integer uid,final Integer euid){
        return new CompaniesAddressData(id,companyId, registeredAddress,uid,euid);
    }
}
