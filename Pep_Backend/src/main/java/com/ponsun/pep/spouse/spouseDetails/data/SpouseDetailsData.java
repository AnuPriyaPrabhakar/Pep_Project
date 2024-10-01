package com.ponsun.pep.spouse.spouseDetails.data;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseDetailsDTO;
import lombok.Data;

@Data
public class SpouseDetailsData {

    private Integer id;
    private Integer pepId;
    private String spouseName;
    private String spousePan;
    private Integer uid;
    private Integer euid;

    public SpouseDetailsData (final Integer id ,final Integer pepId,  final String spouseName , String spousePan ,  final Integer uid , final Integer euid ) {
        this.id = id;
        this.pepId = pepId;
        this.spouseName = spouseName;
        this.spousePan = spousePan;
        this.uid = uid;
        this.euid = euid;
    }
    public static SpouseDetailsData newInstance (final Integer id ,final Integer pepId, final String spouseName , String spousePan , final Integer uid , final Integer euid ) {
        return new SpouseDetailsData(id,pepId,spouseName,spousePan,uid,euid);
    }
}
