package com.ponsun.pep.userTaskView.api;

import com.ponsun.pep.userTaskView.data.UserTaskViewData;
import com.ponsun.pep.userTaskView.services.UserTaskViewWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/UserTaskView")
@Tag(name = "UserTaskView")
public class UserTaskViewApiResource {
    private  final UserTaskViewWritePlatformService firstPageWritePlatformService;

    @GetMapping
    public List<UserTaskViewData> fetchAll(@RequestParam Integer assignTo){
        return this.firstPageWritePlatformService.fetchAllFirstPageData(assignTo);}
}