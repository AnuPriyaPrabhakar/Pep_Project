package com.ponsun.pep.adminconfiguration.AdminUser.services;


import com.ponsun.pep.adminconfiguration.AdminUser.domain.User;

import java.util.List;

public interface UserReadPlatformService {

    User fetchUserById(Integer id);
    List<User> fetchAllUsers();
}
