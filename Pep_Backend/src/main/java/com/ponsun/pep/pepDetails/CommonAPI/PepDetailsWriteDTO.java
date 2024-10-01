package com.ponsun.pep.pepDetails.CommonAPI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.pepDetails.CommonAPI.service.dto.UpdateCheckingData;
import com.ponsun.pep.pepDetails.Customer.request.UpdateCustomerRequest;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;

import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PepDetailsWriteDTO {
//    private UpdateCheckingData updateCheckingData;
//    private CreateCustomerRequest createCustomerRequest;
//    private UpdateCustomerRequest updateCustomerRequest;
//    private List<CreateAkaDetRequest> createAkaDetRequest;
//    private List<CreateContactsDetailsRequest> createContactsDetailsRequest;
//    private List<CreateRelativeRequest> createRelativeRequest;
//    //private CreatePartyRequest createPartyRequest;
//    private List<PartyData> partyDataList;
//    private List<CreateOtherAssociationRequest> createOtherAssociationRequest;
//    private List<CombinedDTO> combinedDTO;
//    private List<RelativeCombineDTO> relativeCombineDTOList;
//    private List<FamilyCombinedDTO> familyCombinedDTOList;
//    private List<SpouseCommonDTO> spouseCommonDTOList;

    private List<CombinedDTO> combinedDTO;
    private CreateCustomerRequest createCustomerRequest;
    private List<CreateRelativeRequest> createRelativeRequest;
    private UpdateCheckingData updateCheckingData;
    private UpdateCustomerRequest updateCustomerRequest;
    private List<CreateAkaDetRequest> createAkaDetRequest;
    private List<CreateContactsDetailsRequest> createContactsDetailsRequest;
    private List<PartyCandidateDetailsData> partyCandidateDetailsDataList;
    private List<CreateOtherAssociationRequest> createOtherAssociationRequest;
    private List<RelativeCombineDTO> relativeCombineDTOList;
    private List<FamilyCombinedDTO> familyCombinedDTOList;
    private List<SpouseCommonDTO> spouseCommonDTOList;
    private List<PartyCommonDto> partyCommonDtoList;

    public PepDetailsWriteDTO(UpdateCheckingData updateCheckingData, CreateCustomerRequest createCustomerRequest, UpdateCustomerRequest updateCustomerRequest, List<CreateAkaDetRequest> createAkaDetRequest, List<CreateContactsDetailsRequest> createContactsDetailsRequest, List<CreateRelativeRequest> createRelativeRequest, List<PartyCandidateDetailsData> partyCandidateDetailsDataList, List<CreateOtherAssociationRequest> createOtherAssociationRequest, List<CombinedDTO> combinedDTO, List<RelativeCombineDTO> relativeCombineDTOList, List<FamilyCombinedDTO> familyCombinedDTOList, List<SpouseCommonDTO> spouseCommonDTOList,List<PartyCommonDto> partyCommonDtoList) {
        this.updateCheckingData=updateCheckingData;
        this.createCustomerRequest = createCustomerRequest;
        this.updateCustomerRequest = updateCustomerRequest;
        this.createAkaDetRequest = createAkaDetRequest;
        this.createContactsDetailsRequest = createContactsDetailsRequest;
        this.createRelativeRequest = createRelativeRequest;
        this.partyCandidateDetailsDataList = partyCandidateDetailsDataList;
        this.createOtherAssociationRequest = createOtherAssociationRequest;
        this.combinedDTO = combinedDTO;
        this.relativeCombineDTOList = relativeCombineDTOList;
        this.familyCombinedDTOList = familyCombinedDTOList;
        this.spouseCommonDTOList = spouseCommonDTOList;
        this.partyCommonDtoList= partyCommonDtoList;
    }

    public static PepDetailsWriteDTO newInstance (UpdateCheckingData updateCheckingData, CreateCustomerRequest createCustomerRequest, UpdateCustomerRequest updateCustomerRequest, List<CreateAkaDetRequest> createAkaDetRequest, List<CreateContactsDetailsRequest> createContactsDetailsRequest, List<CreateRelativeRequest> createRelativeRequest, List<PartyCandidateDetailsData> partyCandidateDetailsDataList, List<CreateOtherAssociationRequest> createOtherAssociationRequest, List<CombinedDTO> combinedDTO, List<RelativeCombineDTO> relativeCombineDTOList, List<FamilyCombinedDTO> familyCombinedDTOList, List<SpouseCommonDTO> spouseCommonDTOList,List<PartyCommonDto> partyCommonDtoList) {
        return new PepDetailsWriteDTO(
                updateCheckingData,
                createCustomerRequest,
                updateCustomerRequest,
                createAkaDetRequest,
                createContactsDetailsRequest,
                createRelativeRequest,
                partyCandidateDetailsDataList,
                createOtherAssociationRequest,
                combinedDTO,
                relativeCombineDTOList,familyCombinedDTOList,spouseCommonDTOList,partyCommonDtoList);
    }
}
