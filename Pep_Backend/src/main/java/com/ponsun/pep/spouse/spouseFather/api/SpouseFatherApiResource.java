package com.ponsun.pep.spouse.spouseFather.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.spouseFather.services.SpouseFatherReadPlatformService;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFather;
import com.ponsun.pep.spouse.spouseFather.request.CreateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.request.UpdateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.services.SpouseFatherWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/SpouseFather")
@Tag(name = "SpouseFatherApiResource")
public class SpouseFatherApiResource {
    private final SpouseFatherWritePlatformService spouseFatherWritePlatformService;
    private final SpouseFatherReadPlatformService spouseFatherReadPlatformService;

    @PostMapping("/CreateSpouseFatherRequest")
    public Response saveSpouseFather(@RequestBody CreateSpouseFatherRequest createSpouseHufRequest) {
        log.debug("START saveCountry request body {}",createSpouseHufRequest);
        Response response = this.spouseFatherWritePlatformService.createSpouseFather(createSpouseHufRequest);
        log.debug("START saveCountry response",response);
        return response;
    }

    @GetMapping
    public List<SpouseFather> fetchAll() {
        return this.spouseFatherReadPlatformService.fetchAllSpouseFather();
    }

    @GetMapping("/{id}")
    public SpouseFather fetchSpouseFatherById(@PathVariable(name = "id") Integer id) {
        return this.spouseFatherReadPlatformService.fetchSpouseFatherById(id);
    }
    @PutMapping("/{id}")
    public Response updateSpouseFather(@PathVariable Integer id, @RequestBody UpdateSpouseFatherRequest updateSpouseHufRequest) {
        log.debug("START updateCountry request body {}",updateSpouseHufRequest);
        Response response = this.spouseFatherWritePlatformService.updateSpouseFather(id, updateSpouseHufRequest);
        log.debug("START updateCountry response",response);
        return response;
    }

    @PutMapping("{id}/block")
    public Response blockSpouseFather(@PathVariable Integer id){
        Response response = this.spouseFatherWritePlatformService.blockSpouseFather(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockSpouseFather(@PathVariable Integer id){
        Response response = this.spouseFatherWritePlatformService.unblockSpouseFather(id);
        return response;
    }

}

