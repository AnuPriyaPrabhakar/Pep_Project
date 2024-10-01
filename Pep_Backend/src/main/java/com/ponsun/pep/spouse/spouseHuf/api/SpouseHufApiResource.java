package com.ponsun.pep.spouse.spouseHuf.api;

import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHuf;
import com.ponsun.pep.spouse.spouseHuf.request.CreateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseHuf.request.UpdateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseHuf.services.SpouseHufReadPlatformService;
import com.ponsun.pep.spouse.spouseHuf.services.SpouseHufWritePlatformService;
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
@RequestMapping("/api/v1/SpouseHuf")
@Tag(name = "SpouseHufApiResource")
public class SpouseHufApiResource {
    private final SpouseHufWritePlatformService spouseHufWritePlatformService;
    private final SpouseHufReadPlatformService spouseHufReadPlatformService;

    @PostMapping("/CreateSpouseHufRequest")
    public Response saveSpouseHuf(@RequestBody CreateSpouseHufRequest createSpouseHufRequest) {
        log.debug("START saveCountry request body {}",createSpouseHufRequest);
        Response response = this.spouseHufWritePlatformService.createSpouseHuf(createSpouseHufRequest);
        log.debug("START saveCountry response",response);
        return response;
    }

    @GetMapping
    public List<SpouseHuf> fetchAll() {
        return this.spouseHufReadPlatformService.fetchAllSpouseHuf();
    }

    @GetMapping("/{id}")
    public SpouseHuf fetchSpouseHufById(@PathVariable(name = "id") Integer id) {
        return this.spouseHufReadPlatformService.fetchSpouseHufById(id);
    }
    @PutMapping("/{id}")
    public Response updateSpouseHuf(@PathVariable Integer id, @RequestBody UpdateSpouseHufRequest updateSpouseHufRequest) {
        log.debug("START updateCountry request body {}",updateSpouseHufRequest);
        Response response = this.spouseHufWritePlatformService.updateSpouseHuf(id, updateSpouseHufRequest);
        log.debug("START updateCountry response",response);
        return response;
    }

    @PutMapping("{id}/block")
    public Response blockSpouseHuf(@PathVariable Integer id){
        Response response = this.spouseHufWritePlatformService.blockSpouseHuf(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockSpouseHuf(@PathVariable Integer id){
        Response response = this.spouseHufWritePlatformService.unblockSpouseHuf(id);
        return response;
    }

}

