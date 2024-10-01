package com.ponsun.pep.pepDetails.ContactsDetails.api;

import com.ponsun.pep.pepDetails.ContactsDetails.domain.ContactsDetails;
import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.UpdateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.services.ContactsDetailsReadPlatformService;
import com.ponsun.pep.pepDetails.ContactsDetails.services.ContactsDetailsWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
    @RequestMapping("/api/v1/ContactsDetails")
@Tag(name = "ContactsDetailsApiResource")
public class ContactsDetailsApiResource {
    private final ContactsDetailsWritePlatformService contactsDetailsWritePlatformService;
    private final ContactsDetailsReadPlatformService contactsDetailsReadPlatformService;

    @PostMapping("/CreateContactsDetailsRequest")
    public Response saveContactsDetails(@RequestBody CreateContactsDetailsRequest createContactsDetailsRequest){
        Response response = this.contactsDetailsWritePlatformService.createContactsDetails(createContactsDetailsRequest);
        return response;
    }
    @GetMapping
    public List<ContactsDetails> fetchAll(){
        return this.contactsDetailsReadPlatformService.fetchAllContactsDetails();
    }
    @GetMapping("/{id}")
    public ContactsDetails fetchContactsDetailsById(@PathVariable(name = "id")Integer id){
        return this.contactsDetailsReadPlatformService.fetchContactsDetailsById(id);
    }
    @PutMapping("/{id}")
    public Response updateContactsDetails(@PathVariable Integer id, @RequestBody UpdateContactsDetailsRequest updateContactsDetailsRequest){
        Response response = this.contactsDetailsWritePlatformService.updateContactsDetails(id, updateContactsDetailsRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockContactsDetails(@PathVariable Integer id) {
        Response response = this.contactsDetailsWritePlatformService.blockContactsDetails(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockContactsDetails(@PathVariable Integer id) {
        Response response = this.contactsDetailsWritePlatformService.unblockContactsDetails(id);
        return response;
    }

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer pepId , @RequestParam Integer uid) {
        Response response = this.contactsDetailsWritePlatformService.deactive(pepId , uid);
        return response;
    }
}
