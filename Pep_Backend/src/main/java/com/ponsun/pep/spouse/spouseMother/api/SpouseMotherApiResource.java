package com.ponsun.pep.spouse.spouseMother.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMother;
import com.ponsun.pep.spouse.spouseMother.request.CreateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.request.UpdateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.services.SpouseMotherReadPlatformService;
import com.ponsun.pep.spouse.spouseMother.services.SpouseMotherWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/SpouseMother")
@Tag(name = "SpouseMotherApiResource")
public class SpouseMotherApiResource {
    private final SpouseMotherWritePlatformService spouseMotherWritePlatformService;
    private final SpouseMotherReadPlatformService spouseMotherReadPlatformService;

    @PostMapping("/CreateSpouseMotherRequest")
    public Response saveSpouseMother(@RequestBody CreateSpouseMotherRequest createSpouseHufRequest) {
        log.debug("START saveCountry request body {}",createSpouseHufRequest);
        Response response = this.spouseMotherWritePlatformService.createSpouseMother(createSpouseHufRequest);
        log.debug("START saveCountry response",response);
        return response;
    }

    @GetMapping
    public List<SpouseMother> fetchAll() {
        return this.spouseMotherReadPlatformService.fetchAllSpouseMother();
    }

    @GetMapping("/{id}")
    public SpouseMother fetchSpouseMotherById(@PathVariable(name = "id") Integer id) {
        return this.spouseMotherReadPlatformService.fetchSpouseMotherById(id);
    }
    @PutMapping("/{id}")
    public Response updateSpouseMother(@PathVariable Integer id, @RequestBody UpdateSpouseMotherRequest updateSpouseHufRequest) {
        log.debug("START updateCountry request body {}",updateSpouseHufRequest);
        Response response = this.spouseMotherWritePlatformService.updateSpouseMother(id, updateSpouseHufRequest);
        log.debug("START updateCountry response",response);
        return response;
    }

    @PutMapping("{id}/block")
    public Response blockSpouseMother(@PathVariable Integer id){
        Response response = this.spouseMotherWritePlatformService.blockSpouseMother(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockSpouseMother(@PathVariable Integer id){
        Response response = this.spouseMotherWritePlatformService.unblockSpouseMother(id);
        return response;
    }

}

