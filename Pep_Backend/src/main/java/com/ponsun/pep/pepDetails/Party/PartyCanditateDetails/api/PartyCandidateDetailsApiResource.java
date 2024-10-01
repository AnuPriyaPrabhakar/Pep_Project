package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.api;


import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetails;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services.PartyCandidateDetailsReadPlatformService;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services.PartyCandidateDetailsWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Party")
@Tag(name = "PartyApiResource")
public class PartyCandidateDetailsApiResource {

    private final PartyCandidateDetailsWritePlatformService partyCandidateDetailsWritePlatformService;
    private final PartyCandidateDetailsReadPlatformService partyCandidateDetailsReadPlatformService;

    @PostMapping("/CreatePartyRequest")
    public Response saveParty(@RequestBody CreatePartyCandidateDetailsRequest createPartyRequest) {
        Response response = this.partyCandidateDetailsWritePlatformService.createParty(createPartyRequest);
        return response;
    }
    @GetMapping
    public List<PartyCandidateDetails> fetchAll() {
        return this.partyCandidateDetailsReadPlatformService.fetchAllParty();
    }
    @GetMapping("/{id}")
    public PartyCandidateDetails fetchPartyById(@PathVariable(name = "id") Integer id) {
        return this.partyCandidateDetailsReadPlatformService.fetchPartyById(id);
    }

}

