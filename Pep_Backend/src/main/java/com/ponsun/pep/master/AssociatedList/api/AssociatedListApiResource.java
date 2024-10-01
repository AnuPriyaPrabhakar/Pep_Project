package com.ponsun.pep.master.AssociatedList.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.AssociatedList.domain.AssociatedList;
import com.ponsun.pep.master.AssociatedList.request.CreateAssociatedListRequest;
import com.ponsun.pep.master.AssociatedList.request.UpdateAssociatedListRequest;
import com.ponsun.pep.master.AssociatedList.services.AssociatedListReadPlatformService;
import com.ponsun.pep.master.AssociatedList.services.AssociatedListWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AssociatedList")
@Tag(name = "AssociatedListApiResource")
public class AssociatedListApiResource {
    private final AssociatedListWritePlatformService associatedListWritePlatformService;
    private final AssociatedListReadPlatformService associatedListReadPlatformService;

    @PostMapping("/CreateAssociatedListRequest")
    public Response saveAssociatedList(@RequestBody CreateAssociatedListRequest createAssociatedListRequest){
        Response response = this.associatedListWritePlatformService.createAssociatedList(createAssociatedListRequest);
        return response;
    }
    @GetMapping
    public List<AssociatedList> fetchAll(){return this.associatedListReadPlatformService.fetchAllAssociatedList();}

    @GetMapping("/{id}")
    public AssociatedList fetchAssociatedListById(@PathVariable(name = "id")Integer id){
        return this.associatedListReadPlatformService.fetchAssociatedListById(id);

    }
    @PutMapping("/{id}")
    public Response updateAssociatedList(@PathVariable Integer id, @RequestBody UpdateAssociatedListRequest updateAssociatedListRequest){
        Response response = this.associatedListWritePlatformService.updateAssociatedList(id, updateAssociatedListRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockAssociatedList(@PathVariable Integer id) {
        Response response = this.associatedListWritePlatformService.blockAssociatedList(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockAssociatedList(@PathVariable Integer id) {
        Response response = this.associatedListWritePlatformService.unblockAssociatedList(id);
        return response;
    }
}
