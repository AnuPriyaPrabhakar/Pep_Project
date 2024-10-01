package com.ponsun.pep.pepDetails.Party.PartyDTO.DTO;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PartyCommonDto {

    private PartyCandidateDetailsDTO partyCandidateDetailsDTO;
    private List<PartyDetailsDTO> partyDetailsDTO;


    public PartyCommonDto ( PartyCandidateDetailsDTO partyCandidateDetailsDTO  , List<PartyDetailsDTO> partyDetailsDTO ) {
        this.partyCandidateDetailsDTO = partyCandidateDetailsDTO;
        this.partyDetailsDTO = partyDetailsDTO;
    }

    public PartyCommonDto newInstance ( PartyCandidateDetailsDTO partyCandidateDetailsDTO  , List<PartyDetailsDTO> partyDetailsDTO ) {
        return new PartyCommonDto(partyCandidateDetailsDTO , partyDetailsDTO);
    }
}
