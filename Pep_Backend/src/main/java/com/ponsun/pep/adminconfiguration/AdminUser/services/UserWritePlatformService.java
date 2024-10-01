package com.ponsun.pep.adminconfiguration.AdminUser.services;

import com.ponsun.pep.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.pep.adminconfiguration.AdminUser.request.UpdateUserRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

public interface UserWritePlatformService {

    Response createUser(CreateUserRequest createUserRequest);


    @Transactional
    Response updateUser(Integer id, UpdateUserRequest updateUserRequest);



    @Transactional
    Response blockUser(Integer id);

    @Transactional
    Response unblockUser(Integer id);
}
