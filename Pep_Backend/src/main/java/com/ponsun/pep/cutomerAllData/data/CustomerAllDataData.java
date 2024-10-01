package com.ponsun.pep.cutomerAllData.data;

import lombok.Data;

@Data
public class CustomerAllDataData {
    private Integer pepId;
    private String userName;
    private String pepName;
    private String dob;
    private String panNum;
    private String sourceLink;
    private String frmDate;
    private String toDate;
    private String uid;
    private String created_at;
    private String fatherName;

    public CustomerAllDataData(final Integer pepId , final String userName , final String  pepName , final String dob , final String panNum , final String sourceLink , final String frmDate , final String toDate, final  String uid , final String created_at,final String fatherName){
        this.pepId = pepId;
        this.userName = userName;
        this.pepName = pepName;
        this.dob = dob;
        this.panNum = panNum;
        this.sourceLink = sourceLink;
        this.fatherName = fatherName;
        this.frmDate = frmDate;
        this.toDate = toDate;
        this.uid = uid;
        this.created_at = created_at;

    }

    public static CustomerAllDataData newInstance (final Integer pepId , final String userName , final String  pepName , final String dob , final String panNum , final String sourceLink ,final String fatherName, final String frmDate , final String toDate, final String uid, final String created_at){

        return new CustomerAllDataData(pepId , userName ,pepName ,  dob ,panNum , sourceLink ,fatherName, frmDate , toDate ,uid , created_at);

    }

}
