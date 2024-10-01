package com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain;

import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.AbstractCompanyAssociationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyAssociationRepositoryWrapper extends AbstractCompanyAssociationRequest {
    private final CompanyAssociationRepository companyAssociationRepository;
    @Transactional
    public CompanyAssociation findOneWithNotFoundDetection(final Integer id){
        return this.companyAssociationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Other Association Not found" + id));
    }
    @Transactional
    public List<CompanyAssociation> findOneCompanyWithNotFoundDetection(final Integer companyId){
        return this.companyAssociationRepository.findByCompanyId(companyId);
    }
    @Override
    public String toString(){ return super.toString();}
}
