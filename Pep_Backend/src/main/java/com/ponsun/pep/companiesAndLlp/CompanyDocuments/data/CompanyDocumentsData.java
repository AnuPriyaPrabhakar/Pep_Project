package com.ponsun.pep.companiesAndLlp.CompanyDocuments.data;
import lombok.Data;

@Data
public class CompanyDocumentsData {
    private Integer id;
    private Integer companyId;
    private Integer pathId;
    private String url ;
    private String documentType;
    private Integer documentCount;
    private Integer uid;
    private Integer euid;

    public CompanyDocumentsData(final Integer id ,final Integer companyId, final Integer pathId, final String url, final String documentType,final Integer documentCount,final Integer uid, final Integer euid) {
        this.id = id;
        this.companyId = companyId;
        this.pathId = pathId;
        this.url = url;
        this.documentType = documentType;
        this.documentCount = documentCount;
        this.uid = uid;
        this.euid = euid;

    }

    public static CompanyDocumentsData newInstance(final Integer id ,final Integer companyId, final Integer pathId, final String url, final String documentType,final Integer documentCount,final Integer uid, final Integer euid) {
        return new CompanyDocumentsData(id,companyId, pathId, url, documentType,documentCount,uid, euid);
    }
}
