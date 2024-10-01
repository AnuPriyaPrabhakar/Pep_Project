package com.ponsun.pep.searchLifcycle.HitRecord.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordData;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecord;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.request.UpdateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.services.HitRecordReadPlatformService;
import com.ponsun.pep.searchLifcycle.HitRecord.services.HitRecordWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/HitRecord")
@Tag(name="HitRecordApiResource")
@CrossOrigin(origins = "http://localhost:3000")

public class HitRecordApiResource {
    private final HitRecordWritePlatformService hitRecordWritePlatformService;
    private final HitRecordReadPlatformService hitRecordReadPlatformService;
    
    @PostMapping("/createHitRecord")
    public Response saveHitRecord (@RequestBody CreateHitRecordRequest createHitRecordRequest){
        Response response = this.hitRecordWritePlatformService.createHitRecord(createHitRecordRequest);
        return response;
    }
    
    @GetMapping
    public List<HitRecord> fetchAll(){return this.hitRecordReadPlatformService.fetchAll();}
    
    @GetMapping("/{id}")
    public HitRecord fetchAllHitRecordById(@PathVariable(name="id")Integer id){
        return this.hitRecordReadPlatformService.fetchAlHitRecordById(id);
    }

    @GetMapping("/searchId")
    public List<HitRecordData> fetchAllSearchById(@RequestParam Integer searchId){
        return this.hitRecordReadPlatformService.fetchAllSearchById(searchId);
    }
    @PutMapping("/{id}")
    public Response updateHitRecord(@PathVariable Integer id,@RequestBody UpdateHitRecordRequest updateHitRecordRequest){
        Response response = this.hitRecordWritePlatformService.updateHitRecord(id,updateHitRecordRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockHitRecord(@PathVariable Integer id){
        Response response = this.hitRecordWritePlatformService.blockHitRecord(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockHitRecord(@PathVariable Integer id){
        Response response = this.hitRecordWritePlatformService.unblockHitRecord(id);
        return response;
    }
}
