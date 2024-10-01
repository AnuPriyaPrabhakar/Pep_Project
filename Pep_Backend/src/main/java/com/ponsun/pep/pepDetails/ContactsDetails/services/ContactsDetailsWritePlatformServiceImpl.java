package com.ponsun.pep.pepDetails.ContactsDetails.services;

import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsDataValidator;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetails;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetailsRepository;
import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetailsRepositoryWrapper;
import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.UpdateContactsDetailsRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.ContactsDetails.rowmapper.ContactsDetailsRowmapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactsDetailsWritePlatformServiceImpl implements ContactsDetailsWritePlatformService{
    private final ContactsDetailsRepository contactsDetailsRepository;
    private final ContactsDetailsRepositoryWrapper contactsDetailsRepositoryWrapper;
    private final ContactsDetailsDataValidator contactsDetailsDataValidator;
    private final JdbcTemplate jdbcTemplate;
    private final ContactsDetailsRowmapper contactsDetailsRowmapper;

    @Override
    @Transactional
    public Response createContactsDetails(CreateContactsDetailsRequest createContactsDetailsRequest) {
        try {
            this.contactsDetailsDataValidator.validateSaveContactsDetails(createContactsDetailsRequest);
            final ContactsDetails contactsDetails = ContactsDetails.create(createContactsDetailsRequest);//entity
            this.contactsDetailsRepository.saveAndFlush(contactsDetails);
            return Response.of(Long.valueOf(contactsDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateContactsDetails(Integer id, UpdateContactsDetailsRequest updateContactsDetailsRequest) {
        try {
            this.contactsDetailsDataValidator.validateUpdateContactsDetails(updateContactsDetailsRequest);
            final ContactsDetails contactsDetails = this.contactsDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            contactsDetails.update(updateContactsDetailsRequest);
            this.contactsDetailsRepository.saveAndFlush(contactsDetails);
            return Response.of(Long.valueOf(contactsDetails.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockContactsDetails(Integer id){
        try {
            final ContactsDetails contactsDetails = this.contactsDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            contactsDetails.setStatus(Status.DELETE); // Or set the appropriate status
            contactsDetails.setUpdatedAt(LocalDateTime.now());
            this.contactsDetailsRepository.saveAndFlush(contactsDetails);
            return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockContactsDetails(Integer id){
        try {
            final ContactsDetails contactsDetails = this.contactsDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            contactsDetails.setStatus(Status.ACTIVE); // Or set the appropriate status
            contactsDetails.setUpdatedAt(LocalDateTime.now());
            this.contactsDetailsRepository.saveAndFlush(contactsDetails);
            return Response.of(Long.valueOf(id));


        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


//    @Override
//    @Transactional
//    public Response deactive(Integer pepId, Integer euid){
//        try{
//            List<ContactsDetailsData> contactsDetailsDataList = this.contactsDetailsRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
//            ModelMapper modelMapper = new ModelMapper();
//            ContactsDetails request = modelMapper.map(contactsDetailsDataList, ContactsDetails.class);
//            request.setEuid(euid);
//            request.setStatus(Status.DELETE);
//            request.onUpdate();
//            return Response.of(request.getId());
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }


    @Override
    @Transactional
    public Response deactive(Integer pepId, Integer euid){
        try{
            Integer ids= 0;
            List<ContactsDetailsData> contactsDetailsDataList = this.contactsDetailsRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
            ModelMapper modelMapper = new ModelMapper();
            for (ContactsDetailsData dto : contactsDetailsDataList) {
                ContactsDetails request = modelMapper.map(dto, ContactsDetails.class);
                request.setEuid(euid);
                request.setStatus(Status.DELETE);
                request.onUpdate();
                this.contactsDetailsRepository.saveAndFlush(request);
                ids=dto.getId();
            }
            return Response.of(ids);
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<ContactsDetailsData> fetchContactsDetailsData(Integer pepId) {

        final ContactsDetailsRowmapper rowMapper = new ContactsDetailsRowmapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE pc.pepId = ? AND pc.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<ContactsDetailsData> contactsDetailsDataList  = jdbcTemplate.query(Qry,contactsDetailsRowmapper,
                new Object[] {pepId}
        );
        return contactsDetailsDataList;
    }
}
