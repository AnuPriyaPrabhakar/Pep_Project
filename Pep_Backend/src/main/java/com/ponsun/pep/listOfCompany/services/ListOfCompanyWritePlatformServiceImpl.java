package com.ponsun.pep.listOfCompany.services;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.listOfCompany.data.ListOfCompanyDataValidator;
import com.ponsun.pep.listOfCompany.domain.ListOfCompany;
import com.ponsun.pep.listOfCompany.domain.ListOfCompanyRepository;
import com.ponsun.pep.listOfCompany.domain.ListOfCompanyRepositoryWrapper;
import com.ponsun.pep.listOfCompany.request.CreateListOfCompanyRequest;
import com.ponsun.pep.listOfCompany.request.UpdateListOfCompanyRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListOfCompanyWritePlatformServiceImpl implements ListOfCompanyWritePlatformService{
    private final ListOfCompanyRepository listOfCompanyRepository;
    private final ListOfCompanyRepositoryWrapper listOfCompanyRepositoryWrapper;
    private final ListOfCompanyDataValidator listOfCompanyDataValidator;
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public Response createListOfCompany(CreateListOfCompanyRequest createListOfCompanyRequest){
        try{
            this.listOfCompanyDataValidator.validateSaveListOfCompany(createListOfCompanyRequest);
            final ListOfCompany listOfCompany = ListOfCompany.create(createListOfCompanyRequest);
            this.listOfCompanyRepository.saveAndFlush(listOfCompany);
            return Response.of(Long.valueOf(listOfCompany.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateListOfCompany(Integer id, UpdateListOfCompanyRequest updateListOfCompanyRequest){
        try{
            this.listOfCompanyDataValidator.validateUpdateListOfCompany(updateListOfCompanyRequest);
            final ListOfCompany listOfCompany = this.listOfCompanyRepositoryWrapper.findOneWithNotFoundDetection(id);
            listOfCompany.update(updateListOfCompanyRequest);
            this.listOfCompanyRepository.saveAndFlush(listOfCompany);
            return  Response.of(Long.valueOf(listOfCompany.getId()));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
