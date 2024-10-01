package com.ponsun.pep.pepDetails.ContactsDetails.domain;

import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.UpdateContactsDetailsRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_contacts_details")
public class ContactsDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "communicationDt")
    private String communicationDt;

    @Column(name = "communicationTypeId")
    private Integer communicationTypeId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static ContactsDetails create(CreateContactsDetailsRequest createContactsDetailsRequest){
        final ContactsDetails contactsDetails = new ContactsDetails();
        contactsDetails.setPepId(createContactsDetailsRequest.getPepId());
        contactsDetails.setCommunicationDt(createContactsDetailsRequest.getCommunicationDt());
        contactsDetails.setCommunicationTypeId(createContactsDetailsRequest.getCommunicationTypeId());
        contactsDetails.setUid(createContactsDetailsRequest.getUid());
        contactsDetails.setStatus(Status.ACTIVE);
        contactsDetails.setCreatedAt(LocalDateTime.now());
        return contactsDetails;
    }
    public void update(final UpdateContactsDetailsRequest updateContactsDetailsRequest){
        this.setPepId(updateContactsDetailsRequest.getPepId());
        this.setCommunicationDt(updateContactsDetailsRequest.getCommunicationDt());
        this.setCommunicationTypeId(updateContactsDetailsRequest.getCommunicationTypeId());
        this.setEuid(updateContactsDetailsRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void deactive(final UpdateContactsDetailsRequest updateContactsDetailsRequest){
        this.setEuid(updateContactsDetailsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
