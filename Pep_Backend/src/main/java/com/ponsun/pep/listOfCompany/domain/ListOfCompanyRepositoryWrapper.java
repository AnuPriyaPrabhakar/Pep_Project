package com.ponsun.pep.listOfCompany.domain;

import com.ponsun.pep.listOfCompany.request.AbstractListOfCompanyRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListOfCompanyRepositoryWrapper extends AbstractListOfCompanyRequest {
    private final ListOfCompanyRepository listOfCompanyRepository;
    @Transactional
    public ListOfCompany findOneWithNotFoundDetection(final Integer id){
        return this.listOfCompanyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("List Of Company Not found "+id));
    }
    @Override
    public String toString() { return  super.toString();}
}
