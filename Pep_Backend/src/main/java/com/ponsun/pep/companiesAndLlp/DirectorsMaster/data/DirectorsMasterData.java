package com.ponsun.pep.companiesAndLlp.DirectorsMaster.data;
import lombok.Data;

@Data
public class DirectorsMasterData {
    private String name;
    private String din;
    private Integer uid;
    private Integer euid;
    public DirectorsMasterData (final String name , final String din , final Integer uid , final Integer euid) {
        this.name = name;
        this.din = din;
        this.uid = uid;
        this.euid = euid;
    }

    public static DirectorsMasterData newInstance (final String name , final String din , final Integer uid , final Integer euid) {
        return new DirectorsMasterData(name , din , uid , euid);
    }
}
