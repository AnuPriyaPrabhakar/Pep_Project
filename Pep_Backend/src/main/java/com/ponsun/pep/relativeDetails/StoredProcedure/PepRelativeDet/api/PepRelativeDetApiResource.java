package com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.api;

import com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.services.PepRelativeDetWritePlatformService;
import com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.data.PepRelativeDetData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/PepRelativeDet")
@Tag(name = "CreateApiResourceThrwSP")
public class PepRelativeDetApiResource {
    private final PepRelativeDetWritePlatformService pepRelativeDetWritePlatformService;
    @PostMapping("/insert")
    public ResponseEntity<String> insertPepRelativeDet(@RequestBody PepRelativeDetData pepRelativeDetData) {
        String result = pepRelativeDetWritePlatformService.insertPepRelativeDet(
                pepRelativeDetData.getPepId(),
                pepRelativeDetData.getRelativeMasterId(),
                pepRelativeDetData.getAllMemberDet(),
                pepRelativeDetData.getIpCreatedBy()
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
