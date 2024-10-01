package com.ponsun.pep.categoryCommon.All.data;
import lombok.Data;

@Data
public class AllData {
    private Integer pepId;
    private String userName;
    private String pepName;
    private String SourceLink;
    private String Education;
    private String PepPan;
    private String PepDob;
    private Integer companyId;
    private String CompanyName;
    private String CINFCRN;
    private String originalDateOfAppointment;
    private String appointmentDate;
    private String cessationDate;

    public AllData (final Integer pepId , final String userName , final String pepName
            , final String SourceLink , final String Education , final String PepPan ,String PepDob
            , final Integer companyId , final String CompanyName , final String CINFCRN , final String originalDateOfAppointment
            , final String appointmentDate , final String cessationDate) {


        this.pepId = pepId;
        this.userName = userName;
        this.pepName = pepName;
        this.SourceLink = SourceLink;
        this.Education = Education;
        this.PepPan = PepPan;
        this.PepDob = PepDob;
        this.companyId = companyId;
        this.CompanyName = CompanyName;
        this.CINFCRN = CINFCRN;
        this.originalDateOfAppointment = originalDateOfAppointment;
        this.appointmentDate = appointmentDate;
        this.cessationDate = cessationDate;
    }

    public static AllData newInstance (final Integer pepId , final String userName , final String pepName
            , final String SourceLink , final String Education , final String PepPan ,String PepDob
            , final Integer companyId , final String CompanyName , final String CINFCRN , final String originalDateOfAppointment
            , final String appointmentDate , final String cessationDate) {

        return new AllData(pepId,userName,pepName,SourceLink,Education,PepPan,PepDob,companyId,CompanyName,CINFCRN,originalDateOfAppointment,appointmentDate,cessationDate);
    }

}
