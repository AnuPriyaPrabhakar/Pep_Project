package com.ponsun.pep.master.gender.api;


import com.ponsun.pep.master.gender.domain.Gender;
import com.ponsun.pep.master.gender.services.GenderReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/Gender")
@Tag(name = "GenderApiResource")
public class GenderApiResource {

    private final GenderReadPlatformService genderReadPlatformService;

    @GetMapping
    public List<Gender> fetchAll() {
        return this.genderReadPlatformService.fetchAllGender();
    }

    @GetMapping("/{id}")
    public Gender fetchGenderById(@PathVariable(name = "id") Integer id) {
        return this.genderReadPlatformService.fetchGenderById(id);
    }
}
