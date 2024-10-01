package com.ponsun.pep.customerDetails.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomerDetailsData {

    private Integer id;
    private String name;
    private String dob;
    private String placeOfBirth;
    private String pan;
    private String directorsIdentificationNumber;


    public CustomerDetailsData(final Integer id , final String  name , final String dob , final String placeOfBirth , final String pan , final String directorsIdentificationNumber){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.placeOfBirth = placeOfBirth;
        this.pan = pan;
        this.directorsIdentificationNumber = directorsIdentificationNumber;
    }


    public static CustomerDetailsData newInstance (final Integer id , final String  name , final String dob , final String placeOfBirth , final String pan , final String directorsIdentificationNumber){
        return new CustomerDetailsData(id , name ,dob ,  placeOfBirth,pan,directorsIdentificationNumber);
    }
}

