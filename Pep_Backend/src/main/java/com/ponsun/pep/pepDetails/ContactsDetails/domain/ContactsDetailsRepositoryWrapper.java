package com.ponsun.pep.pepDetails.ContactsDetails.domain;

import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.ContactsDetails.request.AbstractContactsDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsDetailsRepositoryWrapper extends AbstractContactsDetailsRequest {
    private final ContactsDetailsRepository contactsDetailsRepository;

    @Transactional
    public ContactsDetails findOneWithNotFoundDetection(final Integer id){
        return this.contactsDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ContactsDetails Not found " + id) );

    }
    @Transactional
    public List<ContactsDetailsData> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.contactsDetailsRepository.findByPepId(pepId);
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
