package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain;

import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.AbstractCompaniesDirectorsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompaniesDirectorsRepositoryWrapper extends AbstractCompaniesDirectorsRequest {
    private final CompaniesDirectorsRepository companiesDirectorsRepository;
    @Transactional
    public CompaniesDirectors findOneWithNotFoundDetection(final Integer id){
        return this.companiesDirectorsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Companies Address Not found" + id));
    }

    @Transactional
    public List<CompaniesDirectors> findOnePepIdWithNotFoundDetection(final Integer companyId){
        return this.companiesDirectorsRepository.findByCompanyId(companyId);
    }

    @Override
    public String toString(){ return super.toString();}
}

