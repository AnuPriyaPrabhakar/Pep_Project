package com.ponsun.pep.getDirectors.api;


import com.ponsun.pep.getDirectors.data.GetDirectorsData;
import com.ponsun.pep.getDirectors.services.GetDirectorsReadService;
import com.ponsun.pep.getDirectors.services.GetDirectorsWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/GetDirectors")
@CrossOrigin(origins = "http://localhost:3000")
public class GetDirectorsApiResources {

    private final GetDirectorsReadService getDirectorsReadService;
    private final GetDirectorsWriteService getDirectorsWriteService;
    @GetMapping("/{pan}")
    public List<GetDirectorsData> fetchGetDirectorsData(@RequestParam String pan) {
        return this.getDirectorsReadService.fetchGetDirectorsData(pan);
    }
}
