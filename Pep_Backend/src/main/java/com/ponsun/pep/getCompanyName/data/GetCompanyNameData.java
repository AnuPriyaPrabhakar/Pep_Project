package com.ponsun.pep.getCompanyName.data;

import lombok.Data;

@Data
public class GetCompanyNameData {
    private String companyName;
    private Integer associatedId;
    private Integer pepId;
    //private String customerId;

    public  GetCompanyNameData (final String companyName , final Integer associatedId, final Integer pepId){
        this.companyName = companyName;
        this.associatedId = associatedId;
        this.pepId = pepId;
    }
    public static GetCompanyNameData newInstance (final String companyName , final Integer associatedId,final Integer pepId  ){
        return new GetCompanyNameData(companyName , associatedId ,pepId);
    }
}
