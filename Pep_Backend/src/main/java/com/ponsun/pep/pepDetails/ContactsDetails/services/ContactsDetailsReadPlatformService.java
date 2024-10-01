package com.ponsun.pep.pepDetails.ContactsDetails.services;

import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetails;
import java.util.List;
import java.util.Optional;

public interface ContactsDetailsReadPlatformService {

    ContactsDetails fetchContactsDetailsById(Integer id);
    List<ContactsDetailsData> fetchContactsDetailsByPepId(Integer pepId);
    List<ContactsDetails> fetchAllContactsDetails();
}
