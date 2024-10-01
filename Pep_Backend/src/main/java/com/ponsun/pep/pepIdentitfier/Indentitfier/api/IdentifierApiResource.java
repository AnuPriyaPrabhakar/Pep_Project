//package com.ponsun.pep.Pep.Indentitfier.api;
//
//import com.ponsun.pep.Edit.Manager.data.QcManagerData;
//import com.ponsun.pep.Pep.Indentitfier.data.IdentifierData;
//import com.ponsun.pep.Pep.Indentitfier.services.IdentifierWritePlatformService;
//import com.ponsun.pep.Reports.CreatedAt.data.CreatedAtData;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@Slf4j
//@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("api/v1/ Identifier")
//@Tag(name = "IdentifierApiResource")
//public class IdentifierApiResource {
//
// private final IdentifierWritePlatformService identifierWritePlatformService;
//
//    @GetMapping
//    public List<IdentifierData> fetchAll(@RequestParam String name){
//        return this.identifierWritePlatformService.fetchAllIdentifierData(name);}
//}
package com.ponsun.pep.pepIdentitfier.Indentitfier.api;

import com.ponsun.pep.pepIdentitfier.Indentitfier.data.IdentifierData;
import com.ponsun.pep.pepIdentitfier.Indentitfier.services.IdentifierWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequestMapping("api/v1/Identifier")

@Tag(name = "IdentifierApiResource")
public class IdentifierApiResource {

    private final IdentifierWritePlatformService identifierWritePlatformService;


    @GetMapping
    public List<IdentifierData> fetchAll(@RequestParam String name) {
        return this.identifierWritePlatformService.fetchAllIdentifierData(name);
    }

}
