package com.ponsun.pep.searchLifcycle.FirstlevelPending.service;



import com.ponsun.pep.searchLifcycle.FirstlevelPending.data.FirstlevelPendingData;

import java.util.List;

public interface FirstlevelPendingReadService {
    List<FirstlevelPendingData> fetchAllPendingData(Integer id);

}
