package com.ponsun.pep.pepDetails.Party.PartyDTO.service;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCandidateDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDetails.services.PartyDetailsWriteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyDtoReadServiceImpl implements PartyDtoReadService {

    private final PartyCandidateDetailsRepository partyCandidateDetailsRepository;
    private final PartyDetailsWriteService partyDetailsWriteService;
    public List<PartyCommonDto> getPartyDetails(Integer pepId) {
        List<PartyCandidateDetailsData> partyCandidateDetailsDataList = partyCandidateDetailsRepository.findByPepIdAndStatus(pepId , Status.ACTIVE);
        ModelMapper modelMapper = new ModelMapper();
        List<PartyCommonDto> partyCommonDtoList = new ArrayList<>();

        for (PartyCandidateDetailsData partyCandidateDetailsData : partyCandidateDetailsDataList) {
            PartyCommonDto partyCommonDto = new PartyCommonDto();
            PartyCandidateDetailsDTO partyCandidateDetailsDTO = modelMapper.map(partyCandidateDetailsData, PartyCandidateDetailsDTO.class);
            Integer partyCandidateId = partyCandidateDetailsDTO.getId();
            List<PartyDetailsDTO> partyDetailsDTOS = partyDetailsWriteService.fetchPartyDetailsDTO(pepId, partyCandidateId);
            partyCommonDto.setPartyCandidateDetailsDTO(partyCandidateDetailsDTO);
            partyCommonDto.setPartyDetailsDTO(partyDetailsDTOS);
            partyCommonDtoList.add(partyCommonDto);
        }
        return partyCommonDtoList;
    }
}
