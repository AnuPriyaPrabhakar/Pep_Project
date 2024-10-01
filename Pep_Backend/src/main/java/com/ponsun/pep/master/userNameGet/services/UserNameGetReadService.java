package com.ponsun.pep.master.userNameGet.services;

import com.ponsun.pep.master.userNameGet.data.UserNameGetData;

import java.util.List;

public interface UserNameGetReadService {
    List<UserNameGetData> fetchAllUserNameGet();
}
