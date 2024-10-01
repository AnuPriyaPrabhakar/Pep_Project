//package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@Data
//@RequiredArgsConstructor
//public class CompanyDTO {
//    private Integer id;
//    private Integer associateMasterId;
//    private String CINFCRN;
//    private String companyName;
//    private String originalDateOfAppointment;
//    private Integer uid;
//    private Integer euid;
//
//    public CompanyDTO (Integer id,  Integer associateMasterId, String CINFCRN, String companyName,  String originalDateOfAppointment, Integer uid , Integer euid) {
//        this.id = id;
//        this.associateMasterId = associateMasterId;
//        this.CINFCRN = CINFCRN;
//        this.companyName = companyName;
//        this.originalDateOfAppointment = originalDateOfAppointment;
//        this.uid = uid;
//        this.euid = euid;
//    }
//    public static CompanyDTO newInstance (Integer id,  Integer associateMasterId, String CINFCRN, String companyName,  String originalDateOfAppointment, Integer uid , Integer euid) {
//        return new CompanyDTO(id,associateMasterId,CINFCRN,companyName,originalDateOfAppointment,uid,euid);
//    }
//
//}
package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CompanyDTO {

    private Integer id;
    @JsonProperty("associateMasterId")
    private Integer associateMasterId;
    private String CINFCRN;
    private String companyName;
    private String sourceLink;
    private String originalDateOfAppointment;
    private Integer listAdverseInformation;
    private Integer listRegulatoryAction;
    private Integer listGovernment;
    private Integer typeId;
    private Integer uid;
    private Integer euid;
    //@JsonDeserialize(using = StringListDeserializer.class)
    private List<String> document;

    public CompanyDTO(Integer id, Integer associateMasterId, String CINFCRN, String companyName, String sourceLink, String originalDateOfAppointment, Integer listAdverseInformation, Integer listRegulatoryAction,Integer listGovernment, Integer typeId ,Integer uid, Integer euid, List<String> document) {
        this.id = id;
        this.associateMasterId = associateMasterId;
        this.CINFCRN = CINFCRN;
        this.companyName = companyName;
        this.sourceLink = sourceLink;
        this.originalDateOfAppointment = originalDateOfAppointment;
        this.listAdverseInformation = listAdverseInformation;
        this.listRegulatoryAction = listRegulatoryAction;
        this.listGovernment=listGovernment;
        this.typeId = typeId;
        this.uid = uid;
        this.euid = euid;
        this.document = document;
    }

    public static CompanyDTO newInstance(Integer id, Integer associateMasterId, String CINFCRN, String companyName, String sourceLink, String originalDateOfAppointment, Integer listAdverseInformation, Integer listRegulatoryAction,Integer listGovernment,Integer typeId, Integer uid, Integer euid, List<String> document) {
        return new CompanyDTO(id, associateMasterId, CINFCRN, companyName, sourceLink, originalDateOfAppointment , listAdverseInformation, listRegulatoryAction,listGovernment,typeId, uid, euid,document);
    }
}
//package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
//@Data
//@RequiredArgsConstructor
//public class CompanyDTO {
//    private Integer id;
//    @JsonProperty("associateMasterId")
//    private Integer associateMasterId;
//    private String CINFCRN;
//    private String companyName;
//    private String sourceLink;
//    private String originalDateOfAppointment;
//    private Integer uid;
//    private Integer euid;
//    private List<String> document;
//
//    public CompanyDTO(Integer id, Integer associateMasterId, String CINFCRN, String companyName, String sourceLink, String originalDateOfAppointment, Integer uid, Integer euid, List<String> document) {
//        this.id = id;
//        this.associateMasterId = associateMasterId;
//        this.CINFCRN = CINFCRN;
//        this.companyName = companyName;
//        this.sourceLink = sourceLink;
//        this.originalDateOfAppointment = originalDateOfAppointment;
//        this.uid = uid;
//        this.euid = euid;
//        this.document = document;
//    }
//    public static CompanyDTO newInstance(Integer id, Integer associateMasterId, String CINFCRN, String companyName, String sourceLink, String originalDateOfAppointment, Integer uid, Integer euid, List<String> document) {
//        return new CompanyDTO(id, associateMasterId, CINFCRN, companyName, sourceLink, originalDateOfAppointment, uid, euid,document);
//    }
//}
