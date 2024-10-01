//package com.ponsun.pep.pepDetails.CommonAPI.service.dto;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@Data
//@RequiredArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class UpdateCheckingData {
//    private Boolean  customerRequestEdit;
//    private Integer perMediaForm;
//    private Integer contactEmailEdit;
//    private Integer familyEdit;
//    private Integer spouseFamilyEdit;
//    private Integer relativeformDataEdit;
//    private Integer partyEdit;
//    private Integer listofAssociatedCompaniesEdit;
//
//    public UpdateCheckingData(Boolean  customerRequestEdit, Integer perMediaForm, Integer contactEmailEdit, Integer familyEdit, Integer spouseFamilyEdit, Integer relativeformDataEdit, Integer partyEdit, Integer listofAssociatedCompaniesEdit) {
//        this.customerRequestEdit = customerRequestEdit;
//        this.perMediaForm = perMediaForm;
//        this.contactEmailEdit = contactEmailEdit;
//        this.familyEdit = familyEdit;
//        this.spouseFamilyEdit = spouseFamilyEdit;
//        this.relativeformDataEdit = relativeformDataEdit;
//        this.partyEdit = partyEdit;
//        this.listofAssociatedCompaniesEdit = listofAssociatedCompaniesEdit;
//    }
//    public static UpdateCheckingData newInstance(final Boolean  customerRequestEdit, final Integer perMediaForm, final Integer contactEmailEdit, final Integer familyEdit, final Integer spouseFamilyEdit, final Integer relativeformDataEdit, final Integer partyEdit, final Integer listofAssociatedCompaniesEdit){
//        return new UpdateCheckingData(customerRequestEdit, perMediaForm, contactEmailEdit, familyEdit, spouseFamilyEdit, relativeformDataEdit, partyEdit, listofAssociatedCompaniesEdit);
//    }
//}
package com.ponsun.pep.pepDetails.CommonAPI.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCheckingData {
    private Boolean customerRequestEdit;
    private Boolean perMediaForm;
    private Boolean akaDetRequest;
    private Boolean contactEmailEdit;
    private Boolean familyEdit;
    private Boolean spouseFamilyEdit;
    private Boolean relativeformDataEdit;
    private Boolean partyEdit;
    private Boolean listofAssociatedCompaniesEdit;

    public UpdateCheckingData(Boolean customerRequestEdit, Boolean perMediaForm,Boolean akaDetRequest, Boolean contactEmailEdit, Boolean familyEdit, Boolean spouseFamilyEdit, Boolean relativeformDataEdit, Boolean partyEdit, Boolean listofAssociatedCompaniesEdit) {
        this.customerRequestEdit = customerRequestEdit;
        this.perMediaForm = perMediaForm;
        this.akaDetRequest = akaDetRequest;
        this.contactEmailEdit = contactEmailEdit;
        this.familyEdit = familyEdit;
        this.spouseFamilyEdit = spouseFamilyEdit;
        this.relativeformDataEdit = relativeformDataEdit;
        this.partyEdit = partyEdit;
        this.listofAssociatedCompaniesEdit = listofAssociatedCompaniesEdit;
    }
    public static UpdateCheckingData newInstance(final Boolean customerRequestEdit, final Boolean perMediaForm,Boolean akaDetRequest, final Boolean contactEmailEdit, final Boolean familyEdit, final Boolean spouseFamilyEdit, final Boolean relativeformDataEdit, final Boolean partyEdit, final Boolean listofAssociatedCompaniesEdit){
        return new UpdateCheckingData(customerRequestEdit, perMediaForm,akaDetRequest, contactEmailEdit, familyEdit, spouseFamilyEdit, relativeformDataEdit, partyEdit, listofAssociatedCompaniesEdit);
    }
}

