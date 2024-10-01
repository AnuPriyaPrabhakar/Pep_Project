package com.ponsun.pep.Search.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RecordDTO {
    private Integer id;
    private String name;
    private String dob;
    private String placeOfBirth;
    private String pan;
    private String directorsIdentificationNumber;
    private Double score;
    private Integer searchId;
    private Integer criminalId;
    private Integer hitId;

    public RecordDTO(Integer id, Integer searchId,Integer criminalId,Integer hitId, String name, String dob, String placeOfBirth, String pan, String directorsIdentificationNumber, Double score) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.placeOfBirth = placeOfBirth;
        this.pan = pan;
        this.directorsIdentificationNumber = directorsIdentificationNumber;
        this.score = score;
        this.searchId = searchId;
        this.criminalId = criminalId;
        this.hitId = hitId;
    }

    public static RecordDTO newInstance(Integer id,Integer searchId,Integer criminalId,Integer hitId, String name, String dob, String placeOfBirth, String pan, String directorsIdentificationNumber, Double score){
        return new RecordDTO(id,searchId,criminalId,hitId,name,dob,placeOfBirth,pan,directorsIdentificationNumber,score);
    }
}
