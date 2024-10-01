package com.ponsun.pep.pepDetails.ContactsDetails.services;

import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.UpdateContactsDetailsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface ContactsDetailsWritePlatformService {

    Response createContactsDetails(CreateContactsDetailsRequest createContactsDetailsRequest);
    Response updateContactsDetails(Integer id, UpdateContactsDetailsRequest updateContactsDetailsRequest);
    Response blockContactsDetails(Integer id);
    Response unblockContactsDetails(Integer id);
    Response deactive(Integer pepId, Integer euid);

    List<ContactsDetailsData> fetchContactsDetailsData(Integer pepId);
}
