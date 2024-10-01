package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.AbstractCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompaniesAddressRepositoryWrapper extends AbstractCompaniesAddressRequest {
    private final CompaniesAddressRepository companiesAddressRepository;
    @Transactional
    public CompaniesAddress findOneWithNotFoundDetection(final Integer id){
        return this.companiesAddressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Companies Address Not found" + id));
    }
    @Transactional
    public List<CompaniesAddress> findOnePepIdWithNotFoundDetection(final Integer companyId){
        return this.companiesAddressRepository.findByCompanyId(companyId);
    }
    @Override
    public String toString(){ return super.toString();}
}
