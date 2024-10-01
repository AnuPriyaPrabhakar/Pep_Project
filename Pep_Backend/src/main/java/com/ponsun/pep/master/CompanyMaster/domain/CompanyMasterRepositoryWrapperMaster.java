package com.ponsun.pep.master.CompanyMaster.domain;

import com.ponsun.pep.master.CompanyMaster.request.AbstractCompanyMasterRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyMasterRepositoryWrapperMaster extends AbstractCompanyMasterRequest {
    private final CompanyMasterRepository companyMasterRepository;

    @Transactional
    public CompanyMaster findOneWithNotFoundDetection(final Integer id) {
        return this.companyMasterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
