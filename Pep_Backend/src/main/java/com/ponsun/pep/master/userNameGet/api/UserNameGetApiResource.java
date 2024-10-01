package com.ponsun.pep.master.userNameGet.api;



import com.ponsun.pep.master.userNameGet.data.UserNameGetData;
import com.ponsun.pep.master.userNameGet.services.UserNameGetReadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/UserNameGet")
@Tag(name = "UserNameGetApiResource")
public class UserNameGetApiResource {

    private final UserNameGetReadService userNameGetReadService;

    @GetMapping
    public List<UserNameGetData> fetchAll() {
        return this.userNameGetReadService.fetchAllUserNameGet();
    }

}
