package com.ponsun.pep.taskAssign.api;

import com.ponsun.pep.taskAssign.domain.TaskAssign;
import com.ponsun.pep.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.pep.taskAssign.request.UpdateTaskAssignRequest;
import com.ponsun.pep.taskAssign.services.TaskAssignReadPlatformServiceImpl;
import com.ponsun.pep.taskAssign.services.TaskAssignWritePlatformServiceImpl;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/taskAssign")
@Tag(name ="TaskAssignApiResource")
public class TaskAssignApiResource {
    private final TaskAssignWritePlatformServiceImpl taskAssignWritePlatformService;
    private final TaskAssignReadPlatformServiceImpl taskAssignReadPlatformService;

    @PostMapping("/createTaskAssign")
    public Response saveTaskAssign(@RequestBody CreateTaskAssignRequest createTaskAssignRequest){
       log.debug("START saveTaskAssign request body {}",createTaskAssignRequest);
       Response response = this.taskAssignWritePlatformService.createTaskAssign(createTaskAssignRequest);
       log.debug("START saveTaskAssign response",response);
       return response;
    }

    @GetMapping
    public List<TaskAssign> fetchAll(){
        return this.taskAssignReadPlatformService.fetchAllTaskAssign();
    }
    @GetMapping("/{id}")
    public TaskAssign fetchAllTaskAssignById(@PathVariable Integer id){
        return this.taskAssignReadPlatformService.fetchTaskAssignById(id);
    }
    @PutMapping("/{id}")
    public Response updateTaskAssign(@PathVariable Integer id, @RequestBody UpdateTaskAssignRequest updateTaskAssignRequest){
       log.debug("START updateTaskAssign request body {}",updateTaskAssignRequest);
       Response response = this.taskAssignWritePlatformService.updateTaskAssign(id,updateTaskAssignRequest);
       log.debug("START updateTaskAssign response",response);
       return response;
    }

    @PutMapping("/deactive/{id}")
    public Response deactive(@PathVariable Integer id,Integer euid){
        Response response = this.taskAssignWritePlatformService.deactive(id,euid);
        return response;
    }
//    @PutMapping("/block/{id}")
//    public Response blockTaskAssign(@PathVariable Integer id){
//        Response response = this.taskAssignWritePlatformService.blockTaskAssign(id);
//        return response;
//    }
//    @PutMapping("/unblock/{id}")
//    public Response unblockTaskAssign(@PathVariable Integer id){
//        Response response = this.taskAssignWritePlatformService.unblockTaskAssign(id);
//        return response;
//    }
}
