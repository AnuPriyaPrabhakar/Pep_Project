package com.ponsun.pep.master.RelativeConfig.api;



import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfig;
import com.ponsun.pep.master.RelativeConfig.request.CreateRelativeRequest;
import com.ponsun.pep.master.RelativeConfig.request.UpdateRelativeRequest;
import com.ponsun.pep.master.RelativeConfig.services.RelativeConfigReadPlatformService;
import com.ponsun.pep.master.RelativeConfig.services.RelativeConfigWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/ConfigRelative")
@Tag(name = "ConfigRelativeApiResource")
public class ConfigRelativeApiResource {
    private final RelativeConfigWritePlatformService relativeConfigWritePlatformService;

    private final RelativeConfigReadPlatformService relativeConfigReadPlatformService;

    @PostMapping("/CreateRelativeRequest")
    public Response saveRelative(@RequestBody CreateRelativeRequest createRelativeRequest) {
        Response response = this.relativeConfigWritePlatformService.createRelative(createRelativeRequest);
        return response;
    }


    @GetMapping
    public List<RelativeConfig> fetchAll() {
        return this.relativeConfigReadPlatformService.fetchAllRelative();
    }

    @GetMapping("/{id}")
    public RelativeConfig fetchRelativeById(@PathVariable(name = "id") Integer id) {
        return this.relativeConfigReadPlatformService.fetchRelativeById(id);
    }
    @PutMapping("/{id}")
    public Response updateRelative(@PathVariable Integer id, @RequestBody UpdateRelativeRequest updateRelativeRequest) {
        Response response = this.relativeConfigWritePlatformService.updateRelative(id, updateRelativeRequest);
        return response;
    }


    @DeleteMapping("/{id}")
    public Response deleteRelative(@PathVariable(name = "id") Integer id) {
        Response response = this.relativeConfigWritePlatformService.deleteRelative(id);
        return response;
    }
}