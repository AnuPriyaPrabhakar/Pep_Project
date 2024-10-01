package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CompanyAddressDTO {
    private Integer id;
    private Integer companyId;
    private String registeredAddress;
    private Integer uid;
    private Integer euid;
    public CompanyAddressDTO(Integer id, Integer companyId, String registeredAddress,  Integer uid , Integer euid) {
        this.id = id;
        this.companyId = companyId;
        this.registeredAddress = registeredAddress;
        this.uid = uid;
        this.euid = euid;
    }
    public CompanyAddressDTO newInstance(Integer id, Integer companyId, String registeredAddress, Integer uid , Integer euid) {
        return new CompanyAddressDTO (id,companyId,registeredAddress,uid,euid);
    }
}
