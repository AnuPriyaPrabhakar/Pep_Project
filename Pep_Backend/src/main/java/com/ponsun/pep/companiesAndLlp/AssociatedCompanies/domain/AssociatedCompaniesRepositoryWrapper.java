package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain;

import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.AbstractAssociatedCompaniesRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociatedCompaniesRepositoryWrapper extends AbstractAssociatedCompaniesRequest {
    private final AssociatedCompaniesRepository associatedCompaniesRepository;

    @Transactional
    public AssociatedCompanies findOneWithNotFoundDetection(final Integer id){
        return this.associatedCompaniesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Associated Companies Not found " + id));
    }

    public void save(AssociatedCompanies associatedCompanies) {
        associatedCompaniesRepository.save(associatedCompanies);
    }
    @Override
    public String toString(){ return super.toString();}
}
