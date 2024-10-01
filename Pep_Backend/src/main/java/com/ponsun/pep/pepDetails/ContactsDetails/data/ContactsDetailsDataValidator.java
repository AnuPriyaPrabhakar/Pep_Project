package com.ponsun.pep.pepDetails.ContactsDetails.data;

import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.UpdateContactsDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactsDetailsDataValidator {
    public void validateSaveContactsDetails(final CreateContactsDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("ContactId parameter required");
        }
    }
    public void validateUpdateContactsDetails (final UpdateContactsDetailsRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("ContactId parameter required");
        }
    }
}
