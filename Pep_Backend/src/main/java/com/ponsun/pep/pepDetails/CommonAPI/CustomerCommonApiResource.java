//package com.ponsun.pep.pepDetails.CommonAPI;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ponsun.pep.FilesStorage.service.FileStorageReadPlatformService;
//import com.ponsun.pep.FilesStorage.service.FileStorageWritePlatformService;
//import com.ponsun.pep.RelativeDetails.Relative.data.RelativeData;
//import com.ponsun.pep.RelativeDetails.Relative.services.RelativeReadPlatformService;
//import com.ponsun.pep.RelativeDetails.Relative.services.RelativeWritePlatformService;
//import com.ponsun.pep.RelativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
//import com.ponsun.pep.RelativeDetails.RelativesCommonService.service.RelativeCommonReadService;
//import com.ponsun.pep.RelativeDetails.RelativesCommonService.service.RelativeCommonWriteService;
//import com.ponsun.pep.TaskReassign.services.TaskReassignWritePlatformService;
//import com.ponsun.pep.companiesAndLlp.OtherAssociation.data.OtherAssociationData;
//import com.ponsun.pep.companiesAndLlp.OtherAssociation.request.CreateOtherAssociationRequest;
//import com.ponsun.pep.companiesAndLlp.OtherAssociation.services.OtherAssociationReadPlatformService;
//import com.ponsun.pep.companiesAndLlp.OtherAssociation.services.OtherAssociationWritePlatformService;
//import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
//import com.ponsun.pep.companiesAndLlp.CombinedServices.service.CompanyCompainedReadService;
//import com.ponsun.pep.companiesAndLlp.CombinedServices.service.CompanyCompainedWriteService;
//import com.ponsun.pep.infrastructure.utils.Response;
//import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
//import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
//import com.ponsun.pep.pepDetails.AkaDet.services.AkaDetReadPlatformService;
//import com.ponsun.pep.pepDetails.AkaDet.services.AkaDetWritePlatformService;
//import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
//import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
//import com.ponsun.pep.pepDetails.ContactsDetails.services.ContactsDetailsReadPlatformService;
//import com.ponsun.pep.pepDetails.ContactsDetails.services.ContactsDetailsWritePlatformService;
//import com.ponsun.pep.pepDetails.Customer.domain.Customer;
//import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
//import com.ponsun.pep.pepDetails.Customer.services.CustomerReadPlatformService;
//import com.ponsun.pep.pepDetails.Customer.services.CustomerWritePlatformService;
//import com.ponsun.pep.pepDetails.Party.data.PartyData;
//import com.ponsun.pep.pepDetails.Party.domain.Party;
//import com.ponsun.pep.pepDetails.Party.domain.PartyRepository;
//import com.ponsun.pep.pepDetails.Party.request.CreatePartyRequest;
//import com.ponsun.pep.pepDetails.Party.services.PartyReadPlatformService;
//import com.ponsun.pep.pepDetails.Party.services.PartyWritePlatformService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("api/v1/CustomerSave")
//@Tag(name = "SaveCustomerApiResource")
//public class CustomerCommonApiResource {
//    private final CustomerWritePlatformService customerWritePlatformService;
//    private final AkaDetWritePlatformService akaDetWritePlatformService;
//    private final ContactsDetailsWritePlatformService contactsDetailsWritePlatformService;
//    private final RelativeWritePlatformService relativeWritePlatformService;//
//    private final PartyWritePlatformService partyWritePlatformService;
//    private final OtherAssociationWritePlatformService otherAssociationWritePlatformService;
//    private final CompanyCompainedWriteService companyCompainedWriteService;
//    private final RelativeCommonWriteService relativeCommonWriteService;
//    private final FileStorageWritePlatformService fileStorageWritePlatformService;
//    private final FileStorageReadPlatformService fileStorageReadPlatformService;
//    private final TaskReassignWritePlatformService taskReassignWritePlatformService;
//
//    private final RelativeCommonReadService relativeCommonReadService;
//    private final CompanyCompainedReadService companyCompainedReadService;
//    private final CustomerReadPlatformService customerReadPlatformService;
//    private final AkaDetReadPlatformService akaDetReadPlatformService;
//    private final ContactsDetailsReadPlatformService contactsDetailsReadPlatformService;
//    private final RelativeReadPlatformService relativeReadPlatformService;
//    private final PartyReadPlatformService partyReadPlatformService;
//    private final OtherAssociationReadPlatformService otherAssociationReadPlatformService;
//
//    private final PartyRepository partyRepository;
//
//    @PostMapping("/CreateCustomerDetails")
//    //public Response saveCustomer(@RequestBody PepDetailsWriteDTO pepDetailsWriteDTO) {
//    public Response saveCustomer(@RequestParam("PepDetailsWriteDTO") String pepDTO,@RequestParam("files") MultipartFile[] files,
//                                 @RequestParam("files1") MultipartFile[] files1,
//                                 @RequestParam("files2") MultipartFile[] files2,
//                                 @RequestParam("files3") MultipartFile[] files3,
//                                 @RequestParam("pathId") Integer[] pathId,
//                                 @RequestParam("pathId1") Integer[] pathId1,
//                                 @RequestParam("pathId2") Integer[] pathId2,
//                                 @RequestParam("pathId3") Integer[] pathId3
////                                    int getId,int getAssociatedCompaniesId
//    ) {
//
//        //CreateCompanyDocumentsRequest createCompanyDocumentsRequest = new CreateCompanyDocumentsRequest();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            PepDetailsWriteDTO pepDetailsWriteDTO = objectMapper.readValue(pepDTO, PepDetailsWriteDTO.class);
//
//            //List<CombinedDTO> combinedDTO = pepDetailsWriteDTO.getCombinedDTO();
//
////            CreateCustomerRequest createCustomerRequest = pepDetailsWriteDTO.getCreateCustomerRequest();
////            List<CreateAkaDetRequest> createAkaDetRequest = pepDetailsWriteDTO.getCreateAkaDetRequest();
////            List<CreateContactsDetailsRequest> createContactsDetailsRequest = pepDetailsWriteDTO.getCreateContactsDetailsRequest();
////            //List<CreateRelativeRequest> createRelativeRequest                = pepDetailsWriteDTO.getCreateRelativeRequest();//not yet
////            List<PartyData> partyDataList = pepDetailsWriteDTO.getPartyDataList();
////            List<CreateOtherAssociationRequest> createOtherAssociationRequest = pepDetailsWriteDTO.getCreateOtherAssociationRequest();
////            List<RelativeCombineDTO> relativeCombineDTO = pepDetailsWriteDTO.getRelativeCombineDTOList();
////
////            Response response = this.customerWritePlatformService.createCustomer(createCustomerRequest);
//
////            Integer pepId = (Integer) response.getId();
//            Response response= null;
//            Integer pepId = 10;
////
////            this.taskReassignWritePlatformService.createTaskAssign(pepId, createCustomerRequest.getUid());
////
////            for (CreateAkaDetRequest dto : createAkaDetRequest) {
////                dto.setPepId(pepId);
////                this.akaDetWritePlatformService.createAkaDet(dto);
////            }
////            for (CreateContactsDetailsRequest dto : createContactsDetailsRequest) {
////                dto.setPepId(pepId);
////                this.contactsDetailsWritePlatformService.createContactsDetails(dto);
////            }
//////        for (CreateRelativeRequest dto : createRelativeRequest) {
//////            dto.setPepId(pepId);
//////            this.relativeWritePlatformService.createRelative(dto);
//////        }
////            for (CreateOtherAssociationRequest dto : createOtherAssociationRequest) {
////                dto.setPepId(pepId);
////                this.otherAssociationWritePlatformService.createOtherAssociation(dto);
////            }
////            for (PartyData dto : partyDataList) {
////                CreatePartyRequest createPartyRequest = new CreatePartyRequest();
////                createPartyRequest.setPepId(pepId);
////                createPartyRequest.setFormerAndCurrent(dto.getFormerAndCurrent());
////                createPartyRequest.setStateId(dto.getStateId());
////                createPartyRequest.setCountryId(dto.getCountryId());
////                createPartyRequest.setOtherInformation(dto.getOtherInformation());
////                createPartyRequest.setDied(dto.getDied());
////                createPartyRequest.setPermanentAddress(dto.getPermanentAddress());
////                createPartyRequest.setUid(dto.getUid());
////
////
////                Party party = Party.create(createPartyRequest);
////                this.partyRepository.saveAndFlush(party);
////            }
////
//
////            int associatedCompaniesId;
////            this.companyCompainedWriteService.saveCompanyActivity(pepId, combinedDTO);
//////            this.relativeCommonWriteService.createRelativeDetails(pepId, relativeCombineDTO);
////
////            List<String> messages = new ArrayList<>();
//
//
////            try {
////                for (int j = 0; j < files.length; j++) {
////                    fileStorageReadPlatformService.save(files[j], pepId, pathId[j],0,0);
////                    messages.add(files[j].getOriginalFilename() + " [Successful]");
////                }
////
////                for (int j = 0; j < files1.length; j++) {
////                    fileStorageReadPlatformService.save(files1[j], pepId, pathId1[j],0,0);
////                    messages.add(files1[j].getOriginalFilename() + " [Successful]");
////                }
////
////                for (int j = 0; j < files2.length; j++) {
////                    fileStorageReadPlatformService.save(files2[j], pepId, pathId2[j],0,0);
////                    messages.add(files2[j].getOriginalFilename() + " [Successful]");
////                }
////            } catch (Exception e) {
////                throw new RuntimeException(e);
////            }
//        } catch (JsonMappingException e) {
//            throw new RuntimeException(e);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//            return null;
//    }
//    @GetMapping("/GetAssociatedCompaniesRequest/{pepId}")
//    public PepDetailsReadDTO getCompanyActivity(@PathVariable("pepId") Integer pepId)
//    {
//        ModelMapper modelMapper = new ModelMapper();
//
//        PepDetailsReadDTO pepDetailsReadDTO         = new PepDetailsReadDTO();
//        Customer customer                           = this.customerReadPlatformService.fetchCustomerById(pepId);
//        List<AkaDetData> akaDetData                 = this.akaDetReadPlatformService.findBycustomePepId(pepId);//akaDetReadPlatformService.findBycustomePepId(pepId);
//
//        List<ContactsDetailsData> contactsDetailsDataList   = contactsDetailsReadPlatformService.fetchContactsDetailsByPepId(pepId);
//        List<RelativeData> relativeDataList                 = relativeReadPlatformService.fetchRelativeByPepId(pepId);
//        List<PartyData> partyDataList                           = partyWritePlatformService.fetchPartyDataByPepId(pepId);
//        List<OtherAssociationData> otherAssociationDataList = otherAssociationReadPlatformService.OtherAssociationFindByPepId(pepId);
//        List<CombinedDTO> combinedDTOList         =  companyCompainedReadService.getCompanyActivity(pepId);
//        List<RelativeCombineDTO> relativeCombineDTo = relativeCommonReadService.getRelativeActivity(pepId);
//        CreateCustomerRequest createCustomerRequest     = modelMapper.map(customer, CreateCustomerRequest.class);
//
//        pepDetailsReadDTO.setCreateCustomerRequest(createCustomerRequest);
//        pepDetailsReadDTO.setAkaDetDataList(akaDetData);
//        pepDetailsReadDTO.setContactsDetailsDataList(contactsDetailsDataList);
//        pepDetailsReadDTO.setRelativeDataList(relativeDataList);
//        pepDetailsReadDTO.setPartyDataList(partyDataList);
//        pepDetailsReadDTO.setOtherAssociationDataList(otherAssociationDataList);
//        pepDetailsReadDTO.setCombinedDTO(combinedDTOList);
//        pepDetailsReadDTO.setRelativeCombineDTOList(relativeCombineDTo);
//
//        return pepDetailsReadDTO;
//    }
//
//    @PutMapping("/UpdateCustomerDetails")
////    public void updateCustomer(@RequestParam("pepId") Integer pepId,@RequestParam Integer euid , @RequestBody PepDetailsWriteDTO pepDetailsWriteDTO) {
////        List<CombinedDTO> combinedDTO                                    = pepDetailsWriteDTO.getCombinedDTO();
////        CreateCustomerRequest createCustomerRequest                      = pepDetailsWriteDTO.getCreateCustomerRequest();
////        List<CreateAkaDetRequest> createAkaDetRequest                    = pepDetailsWriteDTO.getCreateAkaDetRequest();
////        List<CreateContactsDetailsRequest> createContactsDetailsRequest  = pepDetailsWriteDTO.getCreateContactsDetailsRequest();
////        List<CreateRelativeRequest> createRelativeRequest                = pepDetailsWriteDTO.getCreateRelativeRequest();//not yet
////        List<PartyData> partyDataList                                    = pepDetailsWriteDTO.getPartyDataList();
////        List<CreateOtherAssociationRequest> createOtherAssociationRequest= pepDetailsWriteDTO.getCreateOtherAssociationRequest();
////        List<RelativeCombineDTO> relativeCombineDTO                      = pepDetailsWriteDTO.getRelativeCombineDTOList();
//    public void updateCustomer(Integer euid,@RequestParam("pepId") Integer pepId, @RequestParam("pathId") Integer[] pathIds, @RequestParam("files") MultipartFile[] files, @RequestParam("files1") MultipartFile[] files1,@RequestParam("files2") MultipartFile[] files2, @RequestParam("PepDetailsWriteDTO") String pepDTO) {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            PepDetailsWriteDTO pepDetailsWriteDTO =  objectMapper.readValue(pepDTO, PepDetailsWriteDTO.class);
//            List<CombinedDTO> combinedDTO                                    = pepDetailsWriteDTO.getCombinedDTO();
//            //CreateCustomerRequest createCustomerRequest                    = pepDetailsWriteDTO.getCreateCustomerRequest();
//            List<CreateAkaDetRequest> createAkaDetRequest                    = pepDetailsWriteDTO.getCreateAkaDetRequest();
//            List<CreateContactsDetailsRequest> createContactsDetailsRequest  = pepDetailsWriteDTO.getCreateContactsDetailsRequest();
//            List<PartyData> partyDataList                                    = pepDetailsWriteDTO.getPartyDataList();
//            List<CreateOtherAssociationRequest> createOtherAssociationRequest= pepDetailsWriteDTO.getCreateOtherAssociationRequest();
//            List<RelativeCombineDTO> relativeCombineDTO                      = pepDetailsWriteDTO.getRelativeCombineDTOList();
//
////        if (files.length != pathId.length) {
////            return ResponseEntity.badRequest().body("Number of files does not match the number of root directories.");
////        }
//        //Response response = this.customerWritePlatformService.createCustomer(createCustomerRequest);
//        //Integer pepId     = (Integer) response.getId();
//
//        if (combinedDTO != null || combinedDTO.equals("") || !combinedDTO.isEmpty()) {
//            this.companyCompainedWriteService.EditCompanyActivity(pepId,euid, combinedDTO);
//        }
//
//        if (partyDataList != null  || partyDataList.equals("") || !partyDataList.isEmpty()) {
//            this.partyWritePlatformService.deactive(pepId, euid);
//            for (PartyData dto : partyDataList) {
//                CreatePartyRequest createPartyRequest = new CreatePartyRequest();
//
//                createPartyRequest.setPepId(pepId);
//                createPartyRequest.setFormerAndCurrent(dto.getFormerAndCurrent());
//                createPartyRequest.setStateId(dto.getStateId());
//                createPartyRequest.setCountryId(dto.getCountryId());
//                createPartyRequest.setOtherInformation(dto.getOtherInformation());
//                createPartyRequest.setDied(dto.getDied());
//                createPartyRequest.setPermanentAddress(dto.getPermanentAddress());
//                createPartyRequest.setUid(dto.getUid());
//
//                Party party = Party.create(createPartyRequest);
//                this.partyRepository.saveAndFlush(party);
//            }
//        }
//
//        if (relativeCombineDTO != null  || relativeCombineDTO.equals("") || !relativeCombineDTO.isEmpty()) {
//            this.relativeCommonWriteService.createAndUpdateRelativeDetails(pepId,euid, relativeCombineDTO);
//        }
//
//        if (createAkaDetRequest != null || createAkaDetRequest.equals("") || !createAkaDetRequest.isEmpty()) {
//            this.akaDetWritePlatformService.deactive(pepId, euid);
//            for (CreateAkaDetRequest dto : createAkaDetRequest) {
//                dto.setPepId(pepId);
//                this.akaDetWritePlatformService.createAkaDet(dto);
//            }
//        }
//
//        if (createContactsDetailsRequest != null || createContactsDetailsRequest.equals("") || !createContactsDetailsRequest.isEmpty()) {
//            this.contactsDetailsWritePlatformService.deactive(pepId , euid);
//            for (CreateContactsDetailsRequest dto : createContactsDetailsRequest) {
//                dto.setPepId(pepId);
//                this.contactsDetailsWritePlatformService.createContactsDetails(dto);
//            }
//        }
//
//        if (createOtherAssociationRequest != null || createOtherAssociationRequest.equals("") || !createOtherAssociationRequest.isEmpty()) {
//            for (CreateOtherAssociationRequest dto : createOtherAssociationRequest) {
//                dto.setPepId(pepId);
//                this.otherAssociationWritePlatformService.createOtherAssociation(dto);
//            }
//        }
//
//
//        if (createOtherAssociationRequest != null || createOtherAssociationRequest.equals("") || !createOtherAssociationRequest.isEmpty()) {
//            this.otherAssociationWritePlatformService.deactive(pepId, euid);
//            for (CreateOtherAssociationRequest dto : createOtherAssociationRequest) {
//                dto.setPepId(pepId);
//                this.otherAssociationWritePlatformService.createOtherAssociation(dto);
//            }
//        }
//
//
//            List<String> messages = new ArrayList<>();
//            AtomicInteger i = new AtomicInteger();
//
//            for (int j = 0; j < files.length; j++) {
//                MultipartFile file = files[j];
//                int pathId = pathIds[j];
//                try {
//                    fileStorageReadPlatformService.renamed((pepId), pathId , file);                     messages.add(file.getOriginalFilename() + " [Successful]");
//                } catch (Exception e) {
//                    messages.add(file.getOriginalFilename() + " <Failed> - " + e.getMessage());
//                }
//            }
//
////        return ResponseEntity.ok("File renamed for: " + euid + " - " + messages.toString());
//
//
////        return response;
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }}
//p
package com.ponsun.pep.pepDetails.CommonAPI;

import com.ponsun.pep.pepDetails.CommonAPI.service.CommonWriteService;
import com.ponsun.pep.infrastructure.utils.Response;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/CustomerSave")
@Tag(name = "SaveCustomerApiResource")
public class CustomerCommonApiResource {
      private final CommonWriteService writeService;
    @PostMapping("/CreateCustomerDetails")
    public Response saveCustomer(@RequestParam("PepDetailsWriteDTO") String pepDTO,
                                 @RequestParam(value = "files", required = false) MultipartFile[] files,
                                 @RequestParam(value = "files1", required = false) MultipartFile[] files1,
                                 @RequestParam(value = "files2", required = false) MultipartFile[] files2,
                                 @RequestParam(value = "files3", required = false) MultipartFile[] files3,
                                 @RequestParam(value = "files4", required = false) MultipartFile[] files4,
                                 @RequestParam(value = "pathIds", required = false) Integer[] pathIds,
                                 @RequestParam(value = "pathIds1", required = false) Integer[] pathIds1,
                                 @RequestParam(value = "pathIds2", required = false) Integer[] pathIds2,
                                 @RequestParam(value = "pathIds3", required = false) Integer[] pathIds3,
                                 @RequestParam(value = "pathIds4", required = false) Integer[] pathIds4,
                                 //@RequestParam(value = "imgId", required = false) Integer imgId,
                                 @RequestParam(value = "cinfcrn", required = false) String[] cinfcrn,
                                 @RequestParam(value = "companyfiles", required = false) MultipartFile[] companyfiles,
                                 @RequestParam(value = "companyfilesPathId", required = false) Integer[] companyfilesPathId)
    {
        return this.writeService.saveCustomer(pepDTO,files,files1,files2,files3,files4,pathIds,pathIds1,pathIds2,pathIds3,pathIds4 ,cinfcrn,companyfiles,companyfilesPathId);
    }

    @GetMapping("/GetAssociatedCompaniesRequest/{pepId}")
    public PepDetailsReadDTO getCompanyActivity(@PathVariable("pepId") Integer pepId)
    {
        return this.writeService.getCompanyActivity(pepId);
    }
    @PutMapping("/UpdateCustomerDetails")
    public void updateCustomer(Integer euid, @RequestParam("pepId") Integer pepId,
                               @RequestParam(value = "files", required = false) MultipartFile[] files,
                               @RequestParam(value = "files1", required = false) MultipartFile[] files1,
                               @RequestParam(value = "files2", required = false) MultipartFile[] files2,
                               @RequestParam(value = "files3", required = false) MultipartFile[] files3,
                               @RequestParam(value = "files4", required = false) MultipartFile[] files4,
                               @RequestParam(value = "pathIds", required = false) Integer[] pathIds,
                               @RequestParam(value = "pathIds1", required = false) Integer[] pathIds1,
                               @RequestParam(value = "pathIds2", required = false) Integer[] pathIds2,
                               @RequestParam(value = "pathIds3", required = false) Integer[] pathIds3,
                               @RequestParam(value = "pathIds4", required = false) Integer[] pathIds4,
                               @RequestParam("PepDetailsWriteDTO") String pepDTO,
                               @RequestParam(value = "cinfcrn", required = false) String[] cinfcrn,
                               @RequestParam(value = "companyfiles", required = false) MultipartFile[] companyfiles,
                               @RequestParam(value = "companyfilesPathId", required = false) Integer[] companyfilesPathId) {
    this.writeService.updateCustomer(
            euid,pepId,
            files,files1,files2,files3,files4,
            pathIds,pathIds1,pathIds2,pathIds3,pathIds4,
            pepDTO,cinfcrn,companyfiles,companyfilesPathId);
    }
}