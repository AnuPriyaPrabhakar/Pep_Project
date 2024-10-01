package com.ponsun.pep.master.State.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.State.request.CreateStateRequest;
import com.ponsun.pep.master.State.request.UpdateStateRequest;

public interface StateWritePlatformService {
    Response createState(CreateStateRequest createStateRequest);
    Response updateState(Integer id, UpdateStateRequest updateStateRequest);
    Response blockState(Integer id);
    Response unblockState(Integer id);
}
