package com.ponsun.pep.pepDetails.ContactsDetails.services;

import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetails;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetailsRepository;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactsDetailsReadPlatformServiceImpl implements  ContactsDetailsReadPlatformService{
    private final ContactsDetailsRepositoryWrapper contactsDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ContactsDetailsRepository contactsDetailsRepository;

    @Override
    public ContactsDetails fetchContactsDetailsById(Integer id){
        return this.contactsDetailsRepository.findById(id).get();
    }
    @Override
    public List<ContactsDetailsData> fetchContactsDetailsByPepId(Integer pepid){
        return this.contactsDetailsRepository.findByPepId(pepid);
    }
    @Override
    public List<ContactsDetails> fetchAllContactsDetails(){
        return this.contactsDetailsRepository.findAll();
    }

}
