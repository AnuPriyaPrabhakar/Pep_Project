package com.ponsun.pep.taskAssignView.api;

import com.ponsun.pep.taskAssignView.data.TaskAssignViewData;
import com.ponsun.pep.taskAssignView.services.TaskAssignViewWritePlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/TaskAssignView")
public class TaskAssignViewApiResource {
    private final TaskAssignViewWritePlatformService taskAssignViewWritePlatformService;

    public TaskAssignViewApiResource(TaskAssignViewWritePlatformService taskAssignViewWritePlatformService){
        this.taskAssignViewWritePlatformService = taskAssignViewWritePlatformService;
    }

    @GetMapping
    public List<TaskAssignViewData> fetchAll(){
        return this.taskAssignViewWritePlatformService.fetchAllTaskAssignViewData();
    }
}
