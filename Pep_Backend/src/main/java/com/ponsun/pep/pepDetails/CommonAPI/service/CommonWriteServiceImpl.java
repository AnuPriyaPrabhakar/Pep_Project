package com.ponsun.pep.pepDetails.CommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.ponsun.pep.FilesStorage.service.FileStorageWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.service.CompanyCompainedReadService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.service.CompanyCompainedWriteService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
import com.ponsun.pep.pepDetails.CommonAPI.service.dto.UpdateCheckingData;
import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.services.OtherAssociationReadPlatformService;
import com.ponsun.pep.pepDetails.OtherAssociation.services.OtherAssociationWritePlatformService;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.service.FamilyCommonReadService;
import com.ponsun.pep.familyDetails.FamilyCommonService.service.FamilyCommonWriteService;
import com.ponsun.pep.getCompanyName.services.GetCompanyNameWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.services.AkaDetReadPlatformService;
import com.ponsun.pep.pepDetails.AkaDet.services.AkaDetWritePlatformService;
import com.ponsun.pep.pepDetails.CommonAPI.PepDetailsReadDTO;
import com.ponsun.pep.pepDetails.CommonAPI.PepDetailsWriteDTO;
import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.services.ContactsDetailsWritePlatformService;
import com.ponsun.pep.pepDetails.Customer.domain.Customer;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.request.UpdateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.services.CustomerReadPlatformService;
import com.ponsun.pep.pepDetails.Customer.services.CustomerWritePlatformService;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetails;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services.PartyCandidateDetailsWritePlatformService;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;
import com.ponsun.pep.pepDetails.Party.PartyDTO.service.PartyDtoReadService;
import com.ponsun.pep.pepDetails.Party.PartyDTO.service.PartyDtoWriteService;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.service.RelativeCommonReadService;
import com.ponsun.pep.relativeDetails.RelativesCommonService.service.RelativeCommonWriteService;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;
import com.ponsun.pep.spouse.SpouseCommonService.service.SpouseCommonReadService;
import com.ponsun.pep.spouse.SpouseCommonService.service.SpouseCommonWriteService;
import com.ponsun.pep.taskReassign.services.TaskReassignWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommonWriteServiceImpl implements CommonWriteService {
    private final CustomerWritePlatformService customerWritePlatformService;
    private final AkaDetWritePlatformService akaDetWritePlatformService;
    private final ContactsDetailsWritePlatformService contactsDetailsWritePlatformService;
    private final PartyCandidateDetailsWritePlatformService partyCandidateDetailsWritePlatformService;
    private final OtherAssociationWritePlatformService otherAssociationWritePlatformService;
    private final CompanyCompainedWriteService companyCompainedWriteService;
    private final RelativeCommonWriteService relativeCommonWriteService;
    // family Service
    private final FamilyCommonWriteService familyCommonWriteService;
    private final SpouseCommonWriteService spouseCommonWriteService;
    private final FileStorageWritePlatformService fileStorageWritePlatformService;
    private final TaskReassignWritePlatformService taskReassignWritePlatformService;
    private final RelativeCommonReadService relativeCommonReadService;
    private final CompanyCompainedReadService companyCompainedReadService;
    private final CustomerReadPlatformService customerReadPlatformService;
    private final AkaDetReadPlatformService akaDetReadPlatformService;
    private final OtherAssociationReadPlatformService otherAssociationReadPlatformService;
    private final FamilyCommonReadService familyCommonReadService;
    private final SpouseCommonReadService spouseCommonReadService;
    private final GetCompanyNameWritePlatformService getCompanyNameWritePlatformService;
    private final PartyCandidateDetailsRepository partyCandidateDetailsRepository;

    private final PartyDtoWriteService partyDtoWriteService;
    private  final PartyDtoReadService partyDtoReadService;

    @Override
    @Transactional
    public Response saveCustomer(String pepDTO, MultipartFile[] files, MultipartFile[] files1, MultipartFile[]
            files2, MultipartFile[] files3, MultipartFile[] files4,
                                 Integer[] pathIds, Integer[] pathIds1,
                                 Integer[] pathIds2, Integer[] pathIds3, Integer[] pathIds4,
                                 String[] cinfcrn, MultipartFile[] companyfiles, Integer[] companyfilesPathId) {

        //Response saveCustomer(pepDTO,files,files1,files2,files3,files4,pathIds,pathIds1,pathIds2,pathIds3,pathIds4,cinfcrn,companyfiles,companyfilesPathId);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            PepDetailsWriteDTO pepDetailsWriteDTO = objectMapper.readValue(pepDTO, PepDetailsWriteDTO.class);
            List<CombinedDTO> combinedDTO = pepDetailsWriteDTO.getCombinedDTO();
            CreateCustomerRequest createCustomerRequest = pepDetailsWriteDTO.getCreateCustomerRequest();
            List<CreateAkaDetRequest> createAkaDetRequest = pepDetailsWriteDTO.getCreateAkaDetRequest();
            List<CreateContactsDetailsRequest> createContactsDetailsRequest = pepDetailsWriteDTO.getCreateContactsDetailsRequest();
            //List<CreateRelativeRequest> createRelativeRequest                = pepDetailsWriteDTO.getCreateRelativeRequest();//not yet
            List<PartyCandidateDetailsData> partyCandidateDetailsDataList = pepDetailsWriteDTO.getPartyCandidateDetailsDataList();
            List<CreateOtherAssociationRequest> createOtherAssociationRequest = pepDetailsWriteDTO.getCreateOtherAssociationRequest();
            List<RelativeCombineDTO> relativeCombineDTO = pepDetailsWriteDTO.getRelativeCombineDTOList();
            List<FamilyCombinedDTO> familyCombinedDTO = pepDetailsWriteDTO.getFamilyCombinedDTOList();
            List<SpouseCommonDTO> spouseCommonDTOS = pepDetailsWriteDTO.getSpouseCommonDTOList();
            List<PartyCommonDto> partyCommonDto = pepDetailsWriteDTO.getPartyCommonDtoList();
//          System.out.println("createCustomerRequest for create: " + createCustomerRequest);

            Response response = this.customerWritePlatformService.createCustomer(createCustomerRequest);
            Integer pepId = (Integer) response.getId();

            this.taskReassignWritePlatformService.createTaskAssign(pepId, createCustomerRequest.getUid());

            for (CreateAkaDetRequest dto : createAkaDetRequest) {
                dto.setPepId(pepId);
                this.akaDetWritePlatformService.createAkaDet(dto);
            }

            if (!familyCombinedDTO.isEmpty()) {
                this.familyCommonWriteService.createFamilyDetails(pepId, familyCombinedDTO);
            }

            if (!spouseCommonDTOS.isEmpty()) {
                this.spouseCommonWriteService.createSpouseDetails(pepId, spouseCommonDTOS);
            }

            if (!createContactsDetailsRequest.isEmpty()) {
                for (CreateContactsDetailsRequest dto : createContactsDetailsRequest) {
                    dto.setPepId(pepId);
                    this.contactsDetailsWritePlatformService.createContactsDetails(dto);
                }
            }

            for (CreateOtherAssociationRequest dto : createOtherAssociationRequest) {
                dto.setPepId(pepId);
                this.otherAssociationWritePlatformService.createOtherAssociation(dto);
            }


            if (!partyCommonDto.isEmpty()) {
                this.partyDtoWriteService.createPartyDetails(pepId, partyCommonDto);
            }


//            for (PartyCandidateDetailsData dto : partyCandidateDetailsDataList) {
//                CreatePartyCandidateDetailsRequest createPartyRequest = new CreatePartyCandidateDetailsRequest();
//                createPartyRequest.setPepId(pepId);
//                createPartyRequest.setPartyMasterId(dto.getPartyMasterId());
//                createPartyRequest.setFormerAndCurrent(dto.getFormerAndCurrent());
//                createPartyRequest.setStateId(dto.getStateId());
//                createPartyRequest.setCountryId(dto.getCountryId());
//                createPartyRequest.setOtherInformation(dto.getOtherInformation());
//                createPartyRequest.setPositionInTheParty(dto.getPositionInTheParty());
//                createPartyRequest.setPositionInTheGovernment(dto.getPositionInTheGovernment());
//                createPartyRequest.setDied(dto.getDied());
//                createPartyRequest.setPermanentAddress(dto.getPermanentAddress());
//                createPartyRequest.setUid(dto.getUid());
//                PartyCandidateDetails partyCandidateDetails = PartyCandidateDetails.create(createPartyRequest);
//                this.partyCandidateDetailsRepository.saveAndFlush(partyCandidateDetails);
//            }
            if (!relativeCombineDTO.isEmpty()) {
                this.relativeCommonWriteService.createRelativeDetails(pepId, relativeCombineDTO);
            }
            int associatedCompaniesId = 0;
            if (!combinedDTO.isEmpty())
                associatedCompaniesId = this.companyCompainedWriteService.saveCompanyActivity(combinedDTO);

            List<String> messages = new ArrayList<>();
            if (associatedCompaniesId != 0) {
                Integer AssociatedId = associatedCompaniesId;
                if (cinfcrn != null && companyfiles.length > 0 && companyfilesPathId != null && companyfilesPathId.length == companyfiles.length) {
                    for (int j = 0; j < companyfiles.length; j++) {
                        AssociatedId = this.getCompanyNameWritePlatformService.getCompanyId(cinfcrn[j]);
                        if (companyfilesPathId[j] != null)
                            this.fileStorageWritePlatformService.companysave(companyfiles[j], companyfilesPathId[j], AssociatedId);
                    }
                }
            }
            try {

                if (files != null && files.length > 0 && pathIds != null && pathIds.length == files.length) {
                    for (int j = 0; j < files.length; j++) {
                        if (files[j] != null) {
                            fileStorageWritePlatformService.save(files[j], pepId, pathIds[j]);
                            messages.add(files[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
                if (files1 != null && files1.length > 0 && pathIds1 != null && pathIds1.length == files1.length) {
                    for (int j = 0; j < files1.length; j++) {
                        if (files1[j] != null) {
                            fileStorageWritePlatformService.save(files1[j], pepId, pathIds1[j]);
                            messages.add(files1[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }

                if (files2 != null && files2.length > 0 && pathIds2 != null && pathIds2.length == files2.length) {
                    for (int j = 0; j < files2.length; j++) {
                        if (files2[j] != null) {
                            fileStorageWritePlatformService.save(files2[j], pepId, pathIds2[j]);
                            messages.add(files2[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
                if (files3 != null && files3.length > 0 && pathIds3 != null && pathIds3.length == files3.length) {
                    for (int j = 0; j < files3.length; j++) {
                        if (files3[j] != null) {
                            fileStorageWritePlatformService.save(files3[j], pepId, pathIds3[j]);
                            messages.add(files3[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
                if (files4 != null && files4.length > 0 && pathIds4 != null && pathIds4.length == files4.length) {
                    for (int j = 0; j < files4.length; j++) {
                        if (files4[j] != null) {
                            fileStorageWritePlatformService.save(files4[j], pepId, pathIds4[j]);
                            messages.add(files4[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response();
    }



    @Override
    @Transactional
    public Response updateCustomer(Integer euid, Integer pepId,
                                   MultipartFile[] files,
                                   MultipartFile[] files1,
                                   MultipartFile[] files2,
                                   MultipartFile[] files3,
                                   MultipartFile[] files4,
                                   Integer[] pathIds,
                                   Integer[] pathIds1,
                                   Integer[] pathIds2,
                                   Integer[] pathIds3,
                                   Integer[] pathIds4,
                                   String pepDTO,
                                   String[] cinfcrn,
                                   MultipartFile[] companyfiles,
                                   Integer[] companyfilesPathId) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.coercionConfigFor(LogicalType.Collection)
                .setCoercion(CoercionInputShape.EmptyString, CoercionAction.AsEmpty);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);


        try {
            PepDetailsWriteDTO pepDetailsWriteDTO           = objectMapper.readValue(pepDTO, PepDetailsWriteDTO.class);
            List<CombinedDTO> combinedDTO                   = pepDetailsWriteDTO.getCombinedDTO();
            UpdateCheckingData updateCheckingData           = pepDetailsWriteDTO.getUpdateCheckingData();

            UpdateCustomerRequest updateCustomerRequests    = pepDetailsWriteDTO.getUpdateCustomerRequest();
            List<CreateAkaDetRequest> createAkaDetRequest   = pepDetailsWriteDTO.getCreateAkaDetRequest();
            List<CreateContactsDetailsRequest> createContactsDetailsRequest = pepDetailsWriteDTO.getCreateContactsDetailsRequest();
            List<PartyCandidateDetailsData> partyCandidateDetailsDataList = pepDetailsWriteDTO.getPartyCandidateDetailsDataList();
            List<CreateOtherAssociationRequest> createOtherAssociationRequest = pepDetailsWriteDTO.getCreateOtherAssociationRequest();
            List<RelativeCombineDTO> relativeCombineDTO     = pepDetailsWriteDTO.getRelativeCombineDTOList();
            List<FamilyCombinedDTO> familyCombinedDTOS      = pepDetailsWriteDTO.getFamilyCombinedDTOList();
            List<SpouseCommonDTO> spouseCommonDTOS          = pepDetailsWriteDTO.getSpouseCommonDTOList();
            List<PartyCommonDto> partyCommonDtos                = pepDetailsWriteDTO.getPartyCommonDtoList();


            System.out.println("partyCommonDtos:" + partyCommonDtos);

            String cin = updateCustomerRequests.getDirectorsIdentificationNumber();

            if (updateCheckingData.getCustomerRequestEdit() != null) {
                this.customerWritePlatformService.updateCustomer(pepId, updateCustomerRequests);
            }

            if (updateCheckingData.getListofAssociatedCompaniesEdit() != null ) {
                if (combinedDTO != null  || combinedDTO.equals("")  || !combinedDTO.isEmpty()) {
                    System.out.println("combinedDTO: " + combinedDTO);
                    this.companyCompainedWriteService.EditCompanyActivity(euid,cin, combinedDTO);
                }
            }

            if (updateCheckingData.getFamilyEdit() != null) {
                if (familyCombinedDTOS != null  || familyCombinedDTOS.equals("")  || !familyCombinedDTOS.isEmpty()) {
                    this.familyCommonWriteService.createAndUpdateFamilyDetails(pepId, euid, familyCombinedDTOS);
                }
            }

            if (updateCheckingData.getSpouseFamilyEdit() != null) {
                if (spouseCommonDTOS != null && !spouseCommonDTOS.isEmpty()) {
                    this.spouseCommonWriteService.createAndUpdateSpouseDetails(pepId, euid, spouseCommonDTOS);
                }
            }


            if (updateCheckingData.getPartyEdit() != null) {
                if (partyCommonDtos != null && !partyCommonDtos.isEmpty()) {
                    this.partyDtoWriteService.createAndUpdatePartyDetails(pepId, euid,partyCommonDtos);
                }
            }

//            if (updateCheckingData.getPartyEdit() != null) {
//                if (partyCandidateDetailsDataList != null && !partyCandidateDetailsDataList.isEmpty()) {
//                    this.partyCandidateDetailsWritePlatformService.deactive(pepId, euid);
//
//                    for (PartyCandidateDetailsData dto : partyCandidateDetailsDataList) {
//                        CreatePartyCandidateDetailsRequest createPartyRequest = new CreatePartyCandidateDetailsRequest();
//
//                        createPartyRequest.setPepId(pepId);
//                        createPartyRequest.setPartyMasterId(dto.getPartyMasterId());
//                        createPartyRequest.setFormerAndCurrent(dto.getFormerAndCurrent());
//                        createPartyRequest.setStateId(dto.getStateId());
//                        createPartyRequest.setCountryId(dto.getCountryId());
//                        createPartyRequest.setOtherInformation(dto.getOtherInformation());
//                        createPartyRequest.setPositionInTheParty(dto.getPositionInTheParty());
//                        createPartyRequest.setPositionInTheGovernment(dto.getPositionInTheGovernment());
//                        createPartyRequest.setDied(dto.getDied());
//                        createPartyRequest.setPermanentAddress(dto.getPermanentAddress());
//                        createPartyRequest.setUid(dto.getUid());
//                        PartyCandidateDetails partyCandidateDetails = PartyCandidateDetails.create(createPartyRequest);
//                        this.partyCandidateDetailsRepository.saveAndFlush(partyCandidateDetails);
//                    }
//                }
//
//            }
            if (updateCheckingData.getRelativeformDataEdit() != null) {
                if (relativeCombineDTO != null && !relativeCombineDTO.isEmpty()) {
                    this.relativeCommonWriteService.createAndUpdateRelativeDetails(pepId, euid, relativeCombineDTO);
                }
            }

            if (updateCheckingData.getAkaDetRequest() != null) {
                if (createAkaDetRequest != null && !createAkaDetRequest.isEmpty()) {
                    this.akaDetWritePlatformService.deactive(pepId, euid);
                    for (CreateAkaDetRequest dto : createAkaDetRequest) {
                        dto.setPepId(pepId);
                        this.akaDetWritePlatformService.createAkaDet(dto);
                    }
                }
            }
            if (updateCheckingData.getContactEmailEdit() != null) {
                if (createContactsDetailsRequest != null && !createContactsDetailsRequest.isEmpty()) {
                    this.contactsDetailsWritePlatformService.deactive(pepId, euid);
                    for (CreateContactsDetailsRequest dto : createContactsDetailsRequest) {
                        dto.setPepId(pepId);
                        this.contactsDetailsWritePlatformService.createContactsDetails(dto);
                    }
                }
            }

            if (updateCheckingData.getPerMediaForm() != null) {
                if (createOtherAssociationRequest != null && !createOtherAssociationRequest.isEmpty()) {

                    this.otherAssociationWritePlatformService.deactive(pepId, euid);
                    for (CreateOtherAssociationRequest dto : createOtherAssociationRequest) {
                        dto.setPepId(pepId);
                        this.otherAssociationWritePlatformService.createOtherAssociation(dto);
                    }
                }
            }

            List<String> messages = new ArrayList<>();
            if (cinfcrn != null && companyfiles.length > 0 && companyfilesPathId != null && companyfilesPathId.length == companyfiles.length) {
                for (int j = 0; j < companyfiles.length; j++) {
                    Integer AssociatedId = this.getCompanyNameWritePlatformService.getCompanyId(cinfcrn[j]);
                    System.out.println("companyfiles" + companyfiles[j] + "companyfilesPathId" + companyfilesPathId[j] + "AssociatedId" + AssociatedId);
                    if (companyfilesPathId[j] != null)
                        this.fileStorageWritePlatformService.companysave(companyfiles[j], companyfilesPathId[j], AssociatedId);
                }
            }
            try {

                if (files != null && files.length > 0 && pathIds != null && pathIds.length == files.length) {
                    for (int j = 0; j < files.length; j++) {
                        if (files[j] != null) {
                            fileStorageWritePlatformService.save(files[j], pepId, pathIds[j]);//Affidavit
                            messages.add(files[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
                if (files1 != null && files1.length > 0 && pathIds1 != null && pathIds1.length == files1.length) {
                    for (int j = 0; j < files1.length; j++) {
                        if (files1[j] != null) {
                            fileStorageWritePlatformService.save(files1[j], pepId, pathIds1[j]);//Affidavit Party
                            messages.add(files1[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }

                if (files2 != null && files2.length > 0 && pathIds2 != null && pathIds2.length == files2.length) {
                    for (int j = 0; j < files2.length; j++) {
                        if (files2[j] != null) {
                            fileStorageWritePlatformService.save(files2[j], pepId, pathIds2[j]);//Din pan
                            messages.add(files2[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
                if (files3 != null && files3.length > 0 && pathIds3 != null && pathIds3.length == files3.length) {
                    for (int j = 0; j < files3.length; j++) {
                        if (files3[j] != null) {
                            fileStorageWritePlatformService.save(files3[j], pepId, pathIds3[j]);//Company llp
                            messages.add(files3[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
                if (files4 != null && files4.length > 0 && pathIds4 != null && pathIds4.length == files4.length) {
                    for (int j = 0; j < files4.length; j++) {
                        if (files4[j] != null) {
                            fileStorageWritePlatformService.save(files4[j], pepId, pathIds4[j]);//
                            messages.add(files4[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (JsonMappingException ex) {
            throw new RuntimeException(ex);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Error processing JSON: " + ex.getMessage(), ex);
        }

        return new Response();
    }

    @Override
    public PepDetailsReadDTO getCompanyActivity(Integer pepId) {
        ModelMapper modelMapper = new ModelMapper();

        PepDetailsReadDTO pepDetailsReadDTO = new PepDetailsReadDTO();
        Customer customer                   = this.customerReadPlatformService.fetchCustomerById(pepId);
        List<AkaDetData> akaDetData         = this.akaDetReadPlatformService.findBycustomePepId(pepId);//akaDetReadPlatformService.findBycustomePepId(pepId);

        List<ContactsDetailsData> contactsDetailsDataList   = contactsDetailsWritePlatformService.fetchContactsDetailsData(pepId);
        List<OtherAssociationData> otherAssociationDataList = otherAssociationReadPlatformService.OtherAssociationFindByPepId(pepId);

        List<CombinedDTO> combinedDTOList = new ArrayList<>();
        if (!customer.getDirectorsIdentificationNumber().isEmpty())
            combinedDTOList = companyCompainedReadService.getCompanyActivity(customer.getDirectorsIdentificationNumber());

        List<RelativeCombineDTO> relativeCombineDTo = relativeCommonReadService.getRelativeActivity(pepId);
        List<FamilyCombinedDTO> familyCombinedDTOS  = familyCommonReadService.getFamilyDetails(pepId);
        List<SpouseCommonDTO> spouseCommonDTOS      = spouseCommonReadService.getSpouseDetails(pepId);
        CreateCustomerRequest createCustomerRequest = modelMapper.map(customer, CreateCustomerRequest.class);
        List<PartyCommonDto> partyCommonDtos = partyDtoReadService.getPartyDetails(pepId);




        pepDetailsReadDTO.setCreateCustomerRequest(createCustomerRequest);
        pepDetailsReadDTO.setAkaDetDataList(akaDetData);
        pepDetailsReadDTO.setContactsDetailsDataList(contactsDetailsDataList);
        pepDetailsReadDTO.setOtherAssociationDataList(otherAssociationDataList);
        pepDetailsReadDTO.setCombinedDTO(combinedDTOList);
        pepDetailsReadDTO.setRelativeCombineDTOList(relativeCombineDTo);
        pepDetailsReadDTO.setFamilyCombinedDTOList(familyCombinedDTOS);
        pepDetailsReadDTO.setSpouseCommonDTOList(spouseCommonDTOS);
        pepDetailsReadDTO.setPartyCommonDtoList(partyCommonDtos);

        return pepDetailsReadDTO;
    }
}
