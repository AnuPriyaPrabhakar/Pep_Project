package com.ponsun.pep.master.Country.data;


import lombok.Data;


@Data
public class CountryData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public CountryData(final Integer id, final String name,final Integer uid,final Integer euid ) {
       this.id=id;
       this.name=name;
       this.uid=uid;
       this.euid=euid;

   }
   public static CountryData newInstance(final Integer id, final String name ,final Integer uid,final Integer euid) {
   return new CountryData(id,name,uid,euid);
   }
}
