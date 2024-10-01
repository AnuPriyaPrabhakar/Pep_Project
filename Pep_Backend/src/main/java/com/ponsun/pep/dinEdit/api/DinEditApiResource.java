package com.ponsun.pep.dinEdit.api;

import com.ponsun.pep.dinEdit.data.DinEditData;
import com.ponsun.pep.dinEdit.request.CreateDinEditRequest;
import com.ponsun.pep.dinEdit.services.DinEditWritePlatformService;
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
@RequestMapping("/api/v1/DinNameEdit")
@Tag(name="DinEdit")
public class DinEditApiResource {

    private final DinEditWritePlatformService dinEditWritePlatformService;

    @GetMapping
    public List<DinEditData> fetchAll(@RequestParam String din){
        return this.dinEditWritePlatformService.fetchAllDinName(din);
    }

    @PostMapping("/CreateDinNameEdit")
    public Response saveDinName(@RequestBody CreateDinEditRequest createDinEditRequest){
        Response response = this.dinEditWritePlatformService.createDinEdit(createDinEditRequest);
        return response;
    }
}
