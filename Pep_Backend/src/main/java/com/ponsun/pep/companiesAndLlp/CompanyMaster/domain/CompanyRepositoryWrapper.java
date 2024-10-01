package com.ponsun.pep.companiesAndLlp.CompanyMaster.domain;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.AbstractCompanyRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyRepositoryWrapper extends AbstractCompanyRequest {
    private final CompanyRepository companyRepository;

    @Transactional
    public Company findOneWithNotFoundDetection(final Integer id) {
        return this.companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
