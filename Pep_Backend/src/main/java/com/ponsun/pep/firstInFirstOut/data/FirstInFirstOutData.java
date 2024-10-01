package com.ponsun.pep.firstInFirstOut.data;

import lombok.Data;

@Data
public class FirstInFirstOutData {
    private Integer id;
    private String name;
    private String sourceLink;
    private String education;
    private String dob;
    private String pan;
    private String directorsIdentificationNumber;



        public FirstInFirstOutData(final Integer id, final String name,final String sourceLink,final String education,final String dob,final String pan,final String directorsIdentificationNumber) {
        this.id=id;
        this.name=name;
        this.sourceLink=sourceLink;
        this.education=education;
        this.dob=dob;
        this.pan=pan;
        this.directorsIdentificationNumber=directorsIdentificationNumber;



    }
    public static FirstInFirstOutData newInstance(final Integer id, final String name,final String sourceLink,final String education,final String dob,final String pan,final String directorsIdentificationNumber) {
        return new FirstInFirstOutData(id, name, sourceLink, education, dob, pan, directorsIdentificationNumber);
    }

}
