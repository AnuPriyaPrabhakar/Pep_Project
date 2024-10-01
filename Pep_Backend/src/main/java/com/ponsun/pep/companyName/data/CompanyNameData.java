package com.ponsun.pep.companyName.data;

import lombok.Data;

@Data
public class CompanyNameData {

    private String companyName;
    private String din;
    private String pan;


    public  CompanyNameData(final String companyName , final String din, final String pan){
        this.companyName = companyName;
        this.din = din;
        this.pan = pan;
    }

    public static CompanyNameData newInstance (final String companyName , final String din , final String pan){
        return new CompanyNameData(companyName,din,pan);
    }
}
