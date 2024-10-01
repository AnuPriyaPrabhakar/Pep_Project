package com.ponsun.pep.spouse.spouseHuf.data;


import lombok.Data;


@Data
public class SpouseHufData {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String hufName;
    private String hufPan;
    private Integer uid;
    private Integer euid;

    public SpouseHufData (final Integer id, final Integer pepId,final Integer spouseId, final String hufName, final String hufPan,final Integer uid,final Integer euid ) {
       this.id=id;
       this.pepId=pepId;
       this.spouseId=spouseId;
       this.hufName=hufName;
       this.hufPan=hufPan;
       this.uid=uid;
       this.euid=euid;

   }
   public static SpouseHufData newInstance (final Integer id, final Integer pepId,final Integer spouseId, final String hufName, final String hufPan,final Integer uid,final Integer euid ) {
   return new SpouseHufData(id,pepId,spouseId,hufName,hufPan,uid,euid);
   }
}
