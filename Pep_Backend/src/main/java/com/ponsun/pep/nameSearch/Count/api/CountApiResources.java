package com.ponsun.pep.nameSearch.Count.api;

import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.dto.SearchDTO;
import com.ponsun.pep.nameSearch.Count.service.CountReadService;
import com.ponsun.pep.nameSearch.Count.service.RecordDetails;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/Count")
@Tag(name = "CountApiResources")
public class CountApiResources {
    private final CountReadService countReadService;
    private final RecordDetails recDet;

    @GetMapping("/RecordsCount")
    public List<RecordDTO> getRecords(@RequestBody SearchDTO searchDTO){
        return this.countReadService.getRecordsCount(searchDTO);
    }
    @GetMapping("/GetRecordsDet")
    public List<Integer> getRecords(){
        return this.recDet.getliststatus();
    }
}
