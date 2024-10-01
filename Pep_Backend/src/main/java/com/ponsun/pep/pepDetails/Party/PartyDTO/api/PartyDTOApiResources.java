package com.ponsun.pep.pepDetails.Party.PartyDTO.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCommonDto;
import com.ponsun.pep.pepDetails.Party.PartyDTO.service.PartyDtoReadService;
import com.ponsun.pep.pepDetails.Party.PartyDTO.service.PartyDtoWriteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/PartyDTO")
@Tag(name = "PartyDTOApiResources")
public class PartyDTOApiResources {

    private final PartyDtoWriteService partyDtoWriteService;
    private final PartyDtoReadService partyDtoReadService;

    @PostMapping("/savePartyDetails/{pepId}")
    public Response savePartyDetails(@PathVariable Integer pepId, @RequestBody List<PartyCommonDto> partyCommonDto) {
        return partyDtoWriteService.createPartyDetails(pepId, partyCommonDto);
    }

    @PutMapping("/updatePartyDetails/{pepId}")
    public Response updatePartyDetails(@PathVariable Integer pepId, @RequestParam Integer euid, @RequestBody List<PartyCommonDto> partyCommonDtos) {
        return partyDtoWriteService.createAndUpdatePartyDetails(pepId, euid, partyCommonDtos);
    }

    @GetMapping("/getPartyDetails/{pepId}")
    public List<PartyCommonDto> getPartyDetails(@RequestParam Integer pepId) {
        return this.partyDtoReadService.getPartyDetails(pepId);
    }
}
