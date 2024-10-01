package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;

import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CompanyContactDTO {
    private Integer companyId;
    private String emailID;
    private Integer uid;
    private Integer euid;

    public CompanyContactDTO(Integer companyId, String emailID, Integer uid, Integer euid) {
        this.companyId = companyId;
        this.emailID = emailID;
        this.uid = uid;
        this.euid = euid;
    }
    public static CompanyContactDTO newInstance (Integer  companyId, String emailID,Integer uid,Integer euid) {
        return new CompanyContactDTO( companyId, emailID,uid,euid);
    }

}
