package com.ponsun.pep.getDocumnetType.data;

import lombok.Data;

@Data
public class GetDocumentTypeData {

    private Integer companyId;
    private Integer pathId;
    private String documentType;
    private String concatenated;

    public  GetDocumentTypeData (final Integer companyId , final Integer pathId , final String documentType, final String concatenated){
        this.companyId = companyId;
        this.pathId = pathId;
        this.documentType = documentType;
        this.concatenated = concatenated;
    }
    public static GetDocumentTypeData newInstance (final Integer companyId , final Integer pathId , final String documentType, final String concatenated){
        return new GetDocumentTypeData(companyId ,pathId , documentType ,concatenated);
    }
}
