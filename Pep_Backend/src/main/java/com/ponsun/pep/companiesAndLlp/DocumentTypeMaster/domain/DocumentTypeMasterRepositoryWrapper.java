package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentTypeMasterRepositoryWrapper {
    private final DocumentTypeMasterRepository documentTypeMasterRepository;

    @Transactional
    public DocumentTypeMaster findOneWithNotFoundDetection(final Integer id) {
        return this.documentTypeMasterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AkaDet Not found " + id) );
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
