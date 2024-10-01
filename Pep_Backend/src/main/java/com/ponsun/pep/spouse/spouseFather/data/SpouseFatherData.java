package com.ponsun.pep.spouse.spouseFather.data;


import lombok.Data;


@Data
public class SpouseFatherData {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String fatherName;
    private String fatherPan;
    private Integer uid;
    private Integer euid;

    public SpouseFatherData(final Integer id, final Integer pepId, final Integer spouseId, final String fatherName, final String fatherPan, final Integer uid, final Integer euid ) {
       this.id=id;
       this.pepId=pepId;
       this.spouseId = spouseId;
       this.fatherName=fatherName;
       this.fatherPan=fatherPan;
       this.uid=uid;
       this.euid=euid;

   }
   public static SpouseFatherData newInstance(final Integer id, final Integer pepId, final Integer spouseId, final String fatherName, final String fatherPan, final Integer uid, final Integer euid ) {
   return new SpouseFatherData(id,pepId,spouseId,fatherName,fatherPan,uid,euid);
   }
}
