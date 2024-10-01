package com.ponsun.pep.master.PartyMaster.api;

import com.ponsun.pep.master.PartyMaster.domain.PartyMaster;
import com.ponsun.pep.master.PartyMaster.request.CreatePartyMasterRequest;
import com.ponsun.pep.master.PartyMaster.request.UpdatePartyMasterRequest;
import com.ponsun.pep.master.PartyMaster.services.PartyMasterReadPlatformService;
import com.ponsun.pep.master.PartyMaster.services.PartyMasterWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/PartyMaster")
@Tag(name = "PartyMasterApiResource")
public class PartyMasterApiResource {

    private final PartyMasterWritePlatformService partyMasterWritePlatformService;
    private final PartyMasterReadPlatformService partyMasterReadPlatformService;
    @PostMapping("/CreatePartyRequest")
    public Response saveParty(@RequestBody CreatePartyMasterRequest createPartyMasterRequest){
        Response response = this.partyMasterWritePlatformService.createPartyMaster(createPartyMasterRequest);
        return response;
    }
    @GetMapping
    public List<PartyMaster> fetchAll(){return this.partyMasterReadPlatformService.fetchAllParty();}
    @GetMapping("/{id}")
    public PartyMaster fetchPartyMasterById(@PathVariable(name = "id") Integer id){
        return this.partyMasterReadPlatformService.fetchPartyMasterById(id);
    }
    @PutMapping("/{id}")
    public Response updateParty(@PathVariable Integer id, @RequestBody UpdatePartyMasterRequest updatePartyMasterRequest){
        Response response = this.partyMasterWritePlatformService.updateParty(id,updatePartyMasterRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockPartyMaster(@PathVariable Integer id){
        Response response = this.partyMasterWritePlatformService.blockPartyMaster(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockPartyMaster(@PathVariable Integer id){
        Response response=this.partyMasterWritePlatformService.unblockPartyMaster(id);
        return response;
    }
}
