package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
public class CombinedDTO {
    private CompanyDTO companyDTO;
    private List<CompanyAddressDTO> addressDTOS;
    private List<CompanyContactDTO> contactDTOS;
    private List<CompaniesDirectorsDTO> companiesDirectorsDTOS;
    private List<CompanyDocumentsDTO>  companyDocumentsDTOS;
    private List<CompanyAssociationDTO> companyAssociationDTOS;
//

    public CombinedDTO(CompanyDTO companyDTO, List<CompanyAddressDTO> addressDTOS, List<CompanyContactDTO> contactDTOS, List<CompaniesDirectorsDTO> companiesDirectorsDTOS
            ,List<CompanyDocumentsDTO>  companyDocumentsDTOS,List<CompanyAssociationDTO> companyAssociationDTOS
    ) {
        this.companyDTO = companyDTO;
        this.addressDTOS = addressDTOS;
        this.contactDTOS = contactDTOS;
        this.companiesDirectorsDTOS = companiesDirectorsDTOS;
        this.companyDocumentsDTOS = companyDocumentsDTOS;
        this.companyAssociationDTOS = companyAssociationDTOS;
    }
    public static CombinedDTO newInstance(CompanyDTO companyDTO, List<CompanyAddressDTO> addressDTOS, List<CompanyContactDTO> contactDTOS,List<CompaniesDirectorsDTO> companiesDirectorsDTOS
            ,List<CompanyDocumentsDTO>  companyDocumentsDTOS , List<CompanyAssociationDTO> companyAssociationDTOS
    ) {
        return new CombinedDTO(companyDTO, addressDTOS,contactDTOS,companiesDirectorsDTOS
                ,companyDocumentsDTOS,companyAssociationDTOS
        );
    }
}
