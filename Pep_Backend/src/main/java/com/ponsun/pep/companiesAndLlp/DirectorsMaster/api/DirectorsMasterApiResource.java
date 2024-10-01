package com.ponsun.pep.companiesAndLlp.DirectorsMaster.api;

import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMaster;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.UpdateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.services.DirectorsMasterReadPlatformService;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.services.DirectorsMasterWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/DirectorsMaster")
@Tag(name = "DirectorsMasterApiResource")
public class DirectorsMasterApiResource {

    private final DirectorsMasterWritePlatformService directorsMasterWritePlatformService;
    private final DirectorsMasterReadPlatformService directorsMasterReadPlatformService;

    @PostMapping("/CreateDirectorsMaster")
    public Response saveDirectorsMaster(@RequestBody CreateDirectorMasterRequest createDirectorMasterRequest){
        Response response = this.directorsMasterWritePlatformService.createDirectorsMaster(createDirectorMasterRequest);
        return response;
    }

    @GetMapping
    public List<DirectorsMaster> fetchAll(){return this.directorsMasterReadPlatformService.fetchAllDirectorsMaster();}

    @GetMapping("/{id}")
    public DirectorsMaster fetchDirectorsMasterById(@PathVariable(name = "id")Integer id){
        return this.directorsMasterReadPlatformService.fetchDirectorsMasterById(id);
    }
    @PutMapping("/UpdateDirectorsMaster")
    public Response updateDirectorsMaster(@RequestParam Integer id , @RequestParam Integer euid , @RequestBody UpdateDirectorMasterRequest updateDirectorMasterRequest){
        Response response = this.directorsMasterWritePlatformService.updateGetDirectors(id , euid , updateDirectorMasterRequest);
        return response;
    }
    @PutMapping("/UpdateDirectorsName")
    public Response updateDirectorsName(@RequestParam Integer id, @RequestBody UpdateDirectorMasterRequest updateDirectorMasterRequest) {
        return this.directorsMasterWritePlatformService.updateDirector(id, updateDirectorMasterRequest);
    }
}
