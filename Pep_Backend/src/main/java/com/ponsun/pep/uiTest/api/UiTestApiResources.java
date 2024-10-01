package com.ponsun.pep.uiTest.api;

import com.ponsun.pep.uiTest.dto.UiReciveRecord;
import com.ponsun.pep.uiTest.dto.UiRecordDTO;
import com.ponsun.pep.uiTest.dto.UiSearchDTO;
import com.ponsun.pep.uiTest.dto.UiSearchDtoVerify;
import com.ponsun.pep.uiTest.service.UiTestReadService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/UiTestApiResources")
@Tag(name = "UiTestApiResources")
public class UiTestApiResources {
    private final UiTestReadService uiTestReadService;
    @GetMapping("/UiTestRecords")
    public List<UiRecordDTO> UiTestRecords(@RequestBody UiSearchDTO uiSearchDTO){
        return this.uiTestReadService.getuiTestRecords(uiSearchDTO);
    }
    @GetMapping("/UiTestAlgorithemRecords")
    public List<UiReciveRecord> UiTestAlgorithemRecords(@RequestBody UiSearchDtoVerify uiSearchDtoVerify){
        return this.uiTestReadService.getUiRecords(uiSearchDtoVerify);
    }
}