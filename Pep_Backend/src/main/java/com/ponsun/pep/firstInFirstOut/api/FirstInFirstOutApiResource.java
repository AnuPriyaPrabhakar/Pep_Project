package com.ponsun.pep.firstInFirstOut.api;

import com.ponsun.pep.firstInFirstOut.data.FirstInFirstOutData;
import com.ponsun.pep.firstInFirstOut.services.FirstInFirstOutReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/FirstInFirstOut")
@Tag(name = "FirstInFirstOutApiResource")
public class FirstInFirstOutApiResource {

    private final FirstInFirstOutReadPlatformService firstInFirstOutReadPlatformService;

    @GetMapping
    public List<FirstInFirstOutData> fetchAll() {
        return this.firstInFirstOutReadPlatformService.getAllCustomersOrderedByIdDesc();
    }



}
