package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services;

import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMaster;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepository;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.rowmapper.DirectorsMasterRowMapper;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMaster;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMasterRepository;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMasterRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class DocumentTypeMasterReadPlatformServiceImpl implements DocumentTypeMasterReadPlatformService{

    private final DocumentTypeMasterRepository documentTypeMasterRepository;
    private final DocumentTypeMasterRepositoryWrapper documentTypeMasterRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<DocumentTypeMaster> fetchAllDocumentTypeMaster() {
        return this.documentTypeMasterRepository.findAll();
    }

    @Override
    public DocumentTypeMaster fetchDocumentTypeMasterById(Integer id) {
        return this.documentTypeMasterRepository.findById(id).get();
    }
}
