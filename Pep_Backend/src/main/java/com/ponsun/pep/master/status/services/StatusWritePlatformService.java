package com.ponsun.pep.master.status.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.status.request.CreateStatusRequest;
import com.ponsun.pep.master.status.request.UpdateStatusRequest;
import org.springframework.transaction.annotation.Transactional;


public interface StatusWritePlatformService {
    Response createStatus(CreateStatusRequest createStatusRequest);


    @Transactional
    Response updateStatus(Integer id, UpdateStatusRequest updateStatusRequest);


    @Transactional
    Response blockStatus(Integer id);

    @Transactional
    Response unblockStatus(Integer id);
}
