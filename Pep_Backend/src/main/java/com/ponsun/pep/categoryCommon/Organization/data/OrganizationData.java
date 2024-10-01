package com.ponsun.pep.categoryCommon.Organization.data;

import lombok.Data;

@Data
public class OrganizationData {
    private Integer companyId;
    private String CompanyName;
    private String CINFCRN;
    private String originalDateOfAppointment;
    private String appointmentDate;
    private String cessationDate;

    public OrganizationData (final Integer companyId, String CompanyName , final String CINFCRN , final String originalDateOfAppointment,final String appointmentDate,final String cessationDate) {
        this.companyId = companyId;
        this.CompanyName = CompanyName;
        this.CINFCRN = CINFCRN;
        this.originalDateOfAppointment = originalDateOfAppointment;
        this.appointmentDate = appointmentDate;
        this.cessationDate = cessationDate;
    }

    public static OrganizationData newInstance (final Integer companyId,final String CompanyName , final String CINFCRN , final String originalDateOfAppointment,final String appointmentDate,final String cessationDate) {
        return new OrganizationData(companyId,CompanyName,CINFCRN,originalDateOfAppointment,appointmentDate,cessationDate);
    }
}
