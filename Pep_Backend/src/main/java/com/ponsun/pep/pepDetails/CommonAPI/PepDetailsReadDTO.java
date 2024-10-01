package com.ponsun.pep.pepDetails.CommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;
import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PepDetailsReadDTO {
    private CreateCustomerRequest createCustomerRequest;
    private List<AkaDetData> akaDetDataList;
    private List<ContactsDetailsData> contactsDetailsDataList;
    private List<RelativeData> relativeDataList;
    private List<OtherAssociationData> otherAssociationDataList;
    private List<CombinedDTO> combinedDTO;
    private List<RelativeCombineDTO> relativeCombineDTOList;
    private List<FamilyCombinedDTO> familyCombinedDTOList;
    private List<SpouseCommonDTO> spouseCommonDTOList;
    private List<PartyCommonDto> partyCommonDtoList;
    public PepDetailsReadDTO(CreateCustomerRequest createCustomerRequest,
                             List<AkaDetData> akaDetDataList, List<ContactsDetailsData> contactsDetailsDataList,
                             List<RelativeData> relativeDataList, List<OtherAssociationData> otherAssociationDataList, List<CombinedDTO> combinedDTO, List<RelativeCombineDTO> relativeCombineDTOList, List<FamilyCombinedDTO> familyCombinedDTOList, List<SpouseCommonDTO> spouseCommonDTOList , List<PartyCommonDto> partyCommonDtoList) {
        this.createCustomerRequest = createCustomerRequest;
        this.akaDetDataList = akaDetDataList;
        this.contactsDetailsDataList = contactsDetailsDataList;
        this.relativeDataList = relativeDataList;
        this.otherAssociationDataList = otherAssociationDataList;
        this.combinedDTO = combinedDTO;
        this.relativeCombineDTOList = relativeCombineDTOList;
        this.familyCombinedDTOList = familyCombinedDTOList;
        this.spouseCommonDTOList=spouseCommonDTOList;
        this.partyCommonDtoList = partyCommonDtoList;
    }
    public static PepDetailsReadDTO newInstance (CreateCustomerRequest createCustomerRequest,
                                                  List<AkaDetData> akaDetDataList,
                                                  List<ContactsDetailsData> contactsDetailsDataList,
                                                  List<RelativeData> relativeDataList,
                                                  List<OtherAssociationData> otherAssociationDataList,
                                                  List<CombinedDTO> combinedDTO,
                                                  List<RelativeCombineDTO> relativeCombineDTOList,
                                                 List<FamilyCombinedDTO> familyCombinedDTOList,
                                                 List<SpouseCommonDTO> spouseCommonDTOList,List<PartyCommonDto> partyCommonDtoList) {
        return new PepDetailsReadDTO(createCustomerRequest,
                akaDetDataList,
                contactsDetailsDataList,
                relativeDataList,
                otherAssociationDataList,
                combinedDTO,
                relativeCombineDTOList,familyCombinedDTOList,spouseCommonDTOList,partyCommonDtoList);
    }


}
