package com.ponsun.pep.categoryCommon.Indiviual.api;

import com.ponsun.pep.categoryCommon.Indiviual.data.IndividualData;
import com.ponsun.pep.categoryCommon.Indiviual.services.IndividualReaPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/Individual")
public class IndividualApiResource {
    private  final IndividualReaPlatformService individualReaPlatformService;

    @GetMapping
    public List<IndividualData> fetchAll(String pepName){
        return this.individualReaPlatformService.fetchAllIndividualData(pepName);}
}
