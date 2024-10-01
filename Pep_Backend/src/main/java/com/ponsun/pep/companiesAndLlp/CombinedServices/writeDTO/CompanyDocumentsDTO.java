package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;


import io.jsonwebtoken.io.IOException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
//@JsonDeserialize(using = MultipartFileDeserializer.class)

public class CompanyDocumentsDTO {
    private Integer documentTypeId;
    private Integer companyId;
    private Integer uid;
    private Integer euid;
    private String[] files3;
    private String documentType;
    private String imageName3;
    private Integer[] path;



    public CompanyDocumentsDTO(
            Integer documentTypeId,
            Integer companyId,
            Integer associatedCompaniesId,
            Integer uid,
            Integer euid,
            String[] files3,
            Integer[] path) {
        this.documentTypeId = documentTypeId;
        this.companyId = companyId;
        //this.associatedCompaniesId = associatedCompaniesId;
        this.uid = uid;
        this.euid = euid;
        this.files3 = files3;
        this.path = path;
    }
    public CompanyDocumentsDTO(Integer documentTypeId, Integer companyId, Integer uid, Integer euid, String[] files3, Integer[] path) {
    }

    public static CompanyDocumentsDTO newInstance(
            Integer documentTypeId, Integer companyId,
            Integer uid, Integer euid
            , String[] files3
            , Integer[] path) {
        return new CompanyDocumentsDTO(documentTypeId, companyId, uid, euid,
                files3,
                path);
    }
}
