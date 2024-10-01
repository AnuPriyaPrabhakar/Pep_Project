package com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain;

import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.AbstractCompanyDocumentsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyDocumentsRepositoryWrapper extends AbstractCompanyDocumentsRequest {
    private final CompanyDocumentsRepository companyDocumentsRepository;

    @Transactional
//    public CompanyDocuments findOneWithNotFoundDetection(final Integer id){
//        return this.companyDocumentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AssociatedList Not found " + id) );
//
//    }

    public CompanyDocuments findOneWithNotFoundDetection(final Integer id){
        return this.companyDocumentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AssociatedList Not found " + id));
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
