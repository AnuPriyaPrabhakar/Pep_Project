package com.ponsun.pep.pepDetails.AkaDet.api;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDet;
import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.request.UpdateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.services.AkaDetReadPlatformService;
import com.ponsun.pep.pepDetails.AkaDet.services.AkaDetWritePlatformService;
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
@RequestMapping("/api/v1/AkaDet")
@Tag(name = "AkaDetApiResource")
public class AkaDetApiResource {
    private final AkaDetWritePlatformService akaDetWritePlatformService;
    private final AkaDetReadPlatformService akaDetReadPlatformService;

    @PostMapping("/CreateAkaDetRequest")
    public Response saveAkaDet(@RequestBody CreateAkaDetRequest createAkaDetRequest){
        Response response = this.akaDetWritePlatformService.createAkaDet(createAkaDetRequest);
        return response;
    }
    @GetMapping
    public List<AkaDet> fetchAll(){return this.akaDetReadPlatformService.fetchAllAkaDet();}

    @GetMapping("/{id}")
    public AkaDet fetchAkaDetById(@PathVariable(name = "id")Integer id){
        return this.akaDetReadPlatformService.fetchAkaDetById(id);

    }
//    @GetMapping("/pepId/{pepId}")
//    public List<AkaDetData> findByPepId(@PathVariable(name = "pepId") Integer pepId){
//        return this.akaDetReadPlatformService.findBycustomePepId(pepId);
//    }


    @PutMapping("/deactive/{pepId}")
    public Response deactive(@PathVariable Integer pepId, Integer euid) {
        Response response = this.akaDetWritePlatformService.deactive(pepId, euid);
        return response;
    }

    @PutMapping("/{id}")
    public Response updateAkaDet(@PathVariable Integer id, @RequestBody UpdateAkaDetRequest updateAkaDetRequest){
        Response response = this.akaDetWritePlatformService.updateAkaDet(id, updateAkaDetRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockAkaDet(@PathVariable Integer id) {
        Response response = this.akaDetWritePlatformService.blockAkaDet(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockAkaDet(@PathVariable Integer id) {
        Response response = this.akaDetWritePlatformService.unblockAkaDet(id);
        return response;
    }
}
