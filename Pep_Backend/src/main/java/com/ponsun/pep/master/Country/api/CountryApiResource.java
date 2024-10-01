package com.ponsun.pep.master.Country.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.Country.domain.Country;
import com.ponsun.pep.master.Country.request.CreateCountryRequest;
import com.ponsun.pep.master.Country.request.UpdateCountryRequest;
import com.ponsun.pep.master.Country.services.CountryReadPlatformService;
import com.ponsun.pep.master.Country.services.CountryWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Country")
@Tag(name = "CountryApiResource")
public class CountryApiResource {
    private final CountryWritePlatformService countryWritePlatformService;
    private final CountryReadPlatformService countryReadPlatformService;

    @PostMapping("/CreateCountryRequest")
    public Response saveCountry(@RequestBody CreateCountryRequest createCountryRequest) {
        log.debug("START saveCountry request body {}",createCountryRequest);
        Response response = this.countryWritePlatformService.createCountry(createCountryRequest);
        log.debug("START saveCountry response",response);
        return response;
    }

    @GetMapping
    public List<Country> fetchAll() {
        return this.countryReadPlatformService.fetchAllCountry();
    }

    @GetMapping("/{id}")
    public Country fetchCountryById(@PathVariable(name = "id") Integer id) {
        return this.countryReadPlatformService.fetchCountryById(id);
    }
    @PutMapping("/{id}")
    public Response updateCountry(@PathVariable Integer id, @RequestBody UpdateCountryRequest updateCountryRequest) {
        log.debug("START updateCountry request body {}",updateCountryRequest);
        Response response = this.countryWritePlatformService.updateCountry(id, updateCountryRequest);
        log.debug("START updateCountry response",response);
        return response;
    }

    @PutMapping("{id}/block")
    public Response blockCountry(@PathVariable Integer id){
        Response response = this.countryWritePlatformService.blockCountry(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockCountry(@PathVariable Integer id){
        Response response = this.countryWritePlatformService.unblockCountry(id);
        return response;
    }

}

