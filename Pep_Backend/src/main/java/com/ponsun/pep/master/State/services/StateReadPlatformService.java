package com.ponsun.pep.master.State.services;

import com.ponsun.pep.master.State.domain.State;

import java.util.List;

public interface StateReadPlatformService {
    State fetchStateById(Integer id);
    List<State> fetchAllState();
}
