package com.ponsun.pep.master.status.services;

import com.ponsun.pep.master.status.domain.Status;

import java.util.List;

public interface StatusReadPlatformService {
    Status fetchStatusById(Integer id);

    List<Status> fetchAllStatus();
}
