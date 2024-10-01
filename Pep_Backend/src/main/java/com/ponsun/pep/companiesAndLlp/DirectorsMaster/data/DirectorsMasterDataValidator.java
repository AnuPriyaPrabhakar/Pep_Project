package com.ponsun.pep.companiesAndLlp.DirectorsMaster.data;



import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.UpdateDirectorMasterRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class DirectorsMasterDataValidator {
    public void validateSaveDirectorsMaster(final CreateDirectorMasterRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("Name parameter required");
        }
    }
    public void validateUpdateDirectorsMaster(final UpdateDirectorMasterRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
}
