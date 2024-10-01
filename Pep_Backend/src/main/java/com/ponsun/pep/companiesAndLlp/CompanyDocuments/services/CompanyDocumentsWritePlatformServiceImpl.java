package com.ponsun.pep.companiesAndLlp.CompanyDocuments.services;


import com.ponsun.pep.companiesAndLlp.CompanyDocuments.data.CompanyDocumentsDataValidator;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocuments;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocumentsRepository;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocumentsRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.CreateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.UpdateCompanyDocumentsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j

public class CompanyDocumentsWritePlatformServiceImpl implements CompanyDocumentsWritePlatformService {

    private final CompanyDocumentsRepository companyDocumentsRepository;
    private final CompanyDocumentsRepositoryWrapper companyDocumentsRepositoryWrapper;
    private final CompanyDocumentsDataValidator companyDocumentsDataValidator;

    @Override
    public Response saveCompanyDocuments(CreateCompanyDocumentsRequest createCompanyDocumentsRequest) {
        try {
            this.companyDocumentsDataValidator.validateSaveCompanyDocuments(createCompanyDocumentsRequest);
            final CompanyDocuments companyDocuments = CompanyDocuments.create(createCompanyDocumentsRequest);//entity
            this.companyDocumentsRepository.saveAndFlush(companyDocuments);
            return Response.of(companyDocuments.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());}
    }


    @Override
    @Transactional
    public Response updateCompanyDocuments(Integer id, UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest) {
        try {
            this.companyDocumentsDataValidator.validateUpdateCompanyDocuments(updateCompanyDocumentsRequest);
            final CompanyDocuments companyDocuments = this.companyDocumentsRepositoryWrapper.findOneWithNotFoundDetection(id);
            companyDocuments.update(updateCompanyDocumentsRequest);
            this.companyDocumentsRepository.saveAndFlush(companyDocuments);
            return Response.of(companyDocuments.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deactivateCompanyDocuments(Integer id,UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest) {
        try {
            this.companyDocumentsDataValidator.validateUpdateCompanyDocuments(updateCompanyDocumentsRequest);
            final CompanyDocuments companyDocuments = this.companyDocumentsRepositoryWrapper.findOneWithNotFoundDetection(id);
            companyDocuments.deactive(updateCompanyDocumentsRequest);
            this.companyDocumentsRepository.saveAndFlush(companyDocuments);
            return Response.of(companyDocuments.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

}
