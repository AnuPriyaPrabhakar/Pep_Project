
package com.ponsun.pep.pepDetails.Pan.api;


import com.ponsun.pep.pepDetails.Pan.data.PanData;
import com.ponsun.pep.pepDetails.Pan.services.PanWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/PanApi")
public class PanApi {
    private final PanWritePlatformService panWritePlatformService;

    @GetMapping
    public List<PanData> fetchAll( @RequestParam String pan){
        return this.panWritePlatformService.getPan(pan);}

}

