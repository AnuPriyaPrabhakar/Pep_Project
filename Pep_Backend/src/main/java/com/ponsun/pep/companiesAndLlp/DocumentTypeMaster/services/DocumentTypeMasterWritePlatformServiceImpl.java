package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services;

import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.data.DocumentTypeMasterDataValidator;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMaster;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMasterRepository;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMasterRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.CreateDocumentTypeMasterRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentTypeMasterWritePlatformServiceImpl implements  DocumentTypeMasterWritePlatformService {


    private final DocumentTypeMasterRepository documentTypeMasterRepository;
    private final DocumentTypeMasterRepositoryWrapper documentTypeMasterRepositoryWrapper;
    private final DocumentTypeMasterDataValidator documentTypeMasterDataValidator;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Response createDocumentTypeMaster(CreateDocumentTypeMasterRequest createDocumentTypeMasterRequest) {
        try {
            this.documentTypeMasterDataValidator.validateSaveDocumentTypeMaster(createDocumentTypeMasterRequest);
            final DocumentTypeMaster documentTypeMaster = DocumentTypeMaster.create(createDocumentTypeMasterRequest);
            this.documentTypeMasterRepository.saveAndFlush(documentTypeMaster);
            return Response.of(Long.valueOf(documentTypeMaster.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public Integer getDocumentType(String documentType, CreateDocumentTypeMasterRequest createDocumentTypeMasterRequest) {
        String selectQuery = "SELECT id FROM pep_config_attached_proof WHERE NAME = ?";
        String documentName = jdbcTemplate.queryForObject(selectQuery, new Object[]{documentType}, String.class);
        String insertQuery = "INSERT INTO pep_document_companies (documentTypeId) VALUES (?)";
        return jdbcTemplate.update(insertQuery, documentName);
        //return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }
}



