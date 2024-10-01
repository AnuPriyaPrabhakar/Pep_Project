package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.AbstractAssCompanyContactDetRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssCompanyContactDetRepositoryWrapper extends AbstractAssCompanyContactDetRequest {

    private final AssCompanyContactDetRepository assCompanyContactDetRepository;

    @Transactional
    public AssCompanyContactDet findOneWithNotFoundDetection(final Integer id) {
        return this.assCompanyContactDetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CompanyDetails Not found " + id));
    }
@Transactional
public List<AssCompanyContactDet> findOnePepIdWithNotFoundDetection(final Integer companyId){
        return this.assCompanyContactDetRepository.findByCompanyId(companyId);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
