package com.ponsun.pep.imageDet.api;

import com.ponsun.pep.imageDet.services.ImageDetReadPlatformService;
import com.ponsun.pep.imageDet.services.ImageDetWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.imageDet.domain.ImageDet;
import com.ponsun.pep.imageDet.request.CreateImageDetRequest;
import com.ponsun.pep.imageDet.request.UpdateImageDetRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/ImageDet")
@Tag(name = "ImageDetApiResource")
public class ImageDetApiResource {

    private final ImageDetWritePlatformService imageDetWritePlatformService;
    private final ImageDetReadPlatformService imageDetReadPlatformService;
    @PostMapping("/CreateImageDetRequest")
    public Response saveImageDet(@RequestBody CreateImageDetRequest createImageDetRequest) {
        log.debug("START saveImageDet request body {}",createImageDetRequest);
        Response response = this.imageDetWritePlatformService.createImageDet(createImageDetRequest);
        log.debug("START saveImageDet response ",response);
        return response;
    }
    @GetMapping
    public List<ImageDet> fetchAll() {
        return this.imageDetReadPlatformService.fetchAllImageDet();
    }

    @GetMapping("/{id}")
    public ImageDet fetchImageDetById(@PathVariable(name = "id") Integer id) {
        return this.imageDetReadPlatformService.fetchImageDetById(id);
    }
    @PutMapping("/{id}")
    public Response updateImageDet(@PathVariable Integer id, @RequestBody UpdateImageDetRequest updateImageDetRequest) {
        log.debug("START updateImageDet request body {}",updateImageDetRequest);
        Response response = this.imageDetWritePlatformService.updateImageDet(id, updateImageDetRequest);
        log.debug("START updateImageDet response",response);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockImageDet(@PathVariable Integer id) {
    Response response = this.imageDetWritePlatformService.blockImageDet(id);
    return response;
}
    @PutMapping("/{id}/unblock")
    public Response unblockImageDet(@PathVariable Integer id) {
        Response response = this.imageDetWritePlatformService.unblockImageDet(id);
        return response;
    }
}
