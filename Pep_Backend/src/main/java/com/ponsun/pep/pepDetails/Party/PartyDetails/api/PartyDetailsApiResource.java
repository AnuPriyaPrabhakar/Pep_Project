package com.ponsun.pep.pepDetails.Party.PartyDetails.api;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAddressDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetails;
import com.ponsun.pep.pepDetails.Party.PartyDetails.request.CreatePartyDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyDetails.services.PartyDetailsReadService;
import com.ponsun.pep.pepDetails.Party.PartyDetails.services.PartyDetailsWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/PartyDetails")
@Tag(name = "PartyDetailsApiResource")
public class PartyDetailsApiResource {

    private final PartyDetailsReadService partyDetailsReadService;
    private final PartyDetailsWriteService partyDetailsWriteService;
    @PostMapping("/CreatePartyRequest")
    public Response saveParty(@RequestBody CreatePartyDetailsRequest createPartyDetailsRequest) {
        Response response = this.partyDetailsWriteService.createPartyDetails(createPartyDetailsRequest);
        return response;
    }

    @GetMapping
    public List<PartyDetails> fetchAll() {
        return this.partyDetailsReadService.fetchAllPartyDetails();
    }

    @GetMapping("/{id}")
    public PartyDetails fetchPartyById(@PathVariable(name = "id") Integer id) {
        return this.partyDetailsReadService.fetchPartyDetailsById(id);
    }

    @GetMapping("/pepId")
    public List<PartyDetailsDTO> fetchPartyDetailsDTO(@RequestParam Integer pepId , @RequestParam Integer partyCandidateId){
        return this.partyDetailsWriteService.fetchPartyDetailsDTO(pepId , partyCandidateId);
    }
}
