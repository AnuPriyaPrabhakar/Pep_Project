package com.ponsun.pep.master.State.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.State.domain.State;
import com.ponsun.pep.master.State.request.CreateStateRequest;
import com.ponsun.pep.master.State.request.UpdateStateRequest;
import com.ponsun.pep.master.State.services.StateReadPlatformService;
import com.ponsun.pep.master.State.services.StateWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/State")
@Tag(name = "StateApiResource")
public class StateApiResource {
    private final StateWritePlatformService stateWritePlatformService;
    private final StateReadPlatformService stateReadPlatformService;
    @PostMapping("/CreateStateRequest")
    public Response saveState(@RequestBody CreateStateRequest createStateRequest){
        Response response = this.stateWritePlatformService.createState(createStateRequest);
        return response;
    }
    @GetMapping
    public List<State> fetchAll(){return this.stateReadPlatformService.fetchAllState();}
    @GetMapping("/{id}")
    public State fetchStateById(@PathVariable(name = "id") Integer id){
        return this.stateReadPlatformService.fetchStateById(id);
    }
    @PutMapping("/{id}")
    public Response updateState(@PathVariable Integer id, @RequestBody UpdateStateRequest updateStateRequest){
        Response response = this.stateWritePlatformService.updateState(id,updateStateRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockState(@PathVariable Integer id){
        Response response = this.stateWritePlatformService.blockState(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockState(@PathVariable Integer id){
        Response response=this.stateWritePlatformService.unblockState(id);
        return response;
    }
}
