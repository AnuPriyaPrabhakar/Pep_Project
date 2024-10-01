package com.ponsun.pep.relativeDetails.RelativesCommonService.api;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.service.RelativeCommonReadService;
import com.ponsun.pep.relativeDetails.RelativesCommonService.service.RelativeCommonWriteService;
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
@RequestMapping("api/v1/RelativesCommonService")
@Tag(name = "RelativesCommonServiceApiResource")
public class RelativesCommonServiceApiResource {
    private final RelativeCommonWriteService relativeCommonWriteService;
    private final RelativeCommonReadService relativeCommonReadService;
    @PostMapping("/saveRelativeDetails/{pepId}")
    public Response saveRelativeDetails(@PathVariable Integer pepId, @RequestBody List<RelativeCombineDTO> relativeCombineDTOS) {
        return relativeCommonWriteService.createRelativeDetails(pepId, relativeCombineDTOS);
    }
}



