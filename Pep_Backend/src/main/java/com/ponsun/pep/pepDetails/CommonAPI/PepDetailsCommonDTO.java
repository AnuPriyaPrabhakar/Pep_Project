package com.ponsun.pep.pepDetails.CommonAPI;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.ContactsDetails.request.CreateContactsDetailsRequest;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
public class PepDetailsCommonDTO {
    private CreateCustomerRequest createCustomerRequest;
    private List<CreateAkaDetRequest> createAkaDetRequest;
    private List<CreateContactsDetailsRequest> createContactsDetailsRequest;
    private List<CreateRelativeRequest> createRelativeRequest;
    private CreatePartyCandidateDetailsRequest createPartyRequest;
    private List<CreateOtherAssociationRequest> createOtherAssociationRequest;
    private List<CombinedDTO> combinedDTO;
    private List<RelativeCombineDTO> relativeCombineDTOList;
    private List<FamilyCombinedDTO> familyCombinedDTOList;
    private List<SpouseCommonDTO> spouseCommonDTOList;
    public PepDetailsCommonDTO(CreateCustomerRequest createCustomerRequest, List<CreateAkaDetRequest> createAkaDetRequest, List<CreateContactsDetailsRequest> createContactsDetailsRequest, List<CreateRelativeRequest> createRelativeRequest, CreatePartyCandidateDetailsRequest createPartyRequest, List<CreateOtherAssociationRequest> createOtherAssociationRequest, List<CombinedDTO> combinedDTO, List<RelativeCombineDTO> relativeCombineDTOList, List<FamilyCombinedDTO> familyCombinedDTOList, List<SpouseCommonDTO> spouseCommonDTOList) {
        this.createCustomerRequest = createCustomerRequest;
        this.createAkaDetRequest = createAkaDetRequest;
        this.createContactsDetailsRequest = createContactsDetailsRequest;
        this.createRelativeRequest = createRelativeRequest;
        this.createPartyRequest = createPartyRequest;
        this.createOtherAssociationRequest = createOtherAssociationRequest;
        this.combinedDTO = combinedDTO;
        this.relativeCombineDTOList = relativeCombineDTOList;
        this.familyCombinedDTOList = familyCombinedDTOList;
        this.spouseCommonDTOList = spouseCommonDTOList;
    }
    public static PepDetailsCommonDTO newInstance(CreateCustomerRequest createCustomerRequest, List<CreateAkaDetRequest> createAkaDetRequest, List<CreateContactsDetailsRequest> createContactsDetailsRequest, List<CreateRelativeRequest> createRelativeRequest, CreatePartyCandidateDetailsRequest createPartyRequest, List<CreateOtherAssociationRequest> createOtherAssociationRequest, List<CombinedDTO> combinedDTO, List<RelativeCombineDTO> relativeCombineDTOList, List<FamilyCombinedDTO> familyCombinedDTOList, List<SpouseCommonDTO> spouseCommonDTOList) {
        return new PepDetailsCommonDTO(createCustomerRequest, createAkaDetRequest, createContactsDetailsRequest, createRelativeRequest, createPartyRequest, createOtherAssociationRequest, combinedDTO, relativeCombineDTOList,familyCombinedDTOList,spouseCommonDTOList);
    }

}
