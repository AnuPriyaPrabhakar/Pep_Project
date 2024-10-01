package com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO;

import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.data.DocumentTypeMasterData;
import lombok.Data;

@Data
public class DocumentTypeDTO {

    private String name;
    private Integer uid;
    private Integer euid;

    public DocumentTypeDTO (final String name , final Integer uid , final Integer euid) {
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }

    public static DocumentTypeDTO newInstance (final String name  , final Integer uid , final Integer euid) {
        return new DocumentTypeDTO(name , uid , euid);
    }
}
