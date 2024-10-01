package com.ponsun.pep.spouse.spouseMother.data;


import lombok.Data;


@Data
public class SpouseMotherData {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String motherName;
    private String motherPan;
    private Integer uid;
    private Integer euid;

    public SpouseMotherData(final Integer id, final Integer pepId, final Integer spouseId, final String motherName, final String motherPan, final Integer uid, final Integer euid ) {
       this.id=id;
       this.pepId=pepId;
       this.spouseId = spouseId;
       this.motherName=motherName;
       this.motherPan=motherPan;
       this.uid=uid;
       this.euid=euid;

   }
   public static SpouseMotherData newInstance(final Integer id, final Integer pepId, final Integer spouseId, final String motherName, final String motherPan, final Integer uid, final Integer euid ) {
   return new SpouseMotherData(id,pepId,spouseId,motherName,motherPan,uid,euid);
   }
}
