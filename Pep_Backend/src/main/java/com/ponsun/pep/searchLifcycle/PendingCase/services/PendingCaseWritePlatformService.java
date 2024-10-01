package com.ponsun.pep.searchLifcycle.PendingCase.services;



import com.ponsun.pep.searchLifcycle.PendingCase.data.PendingCaseData;

import java.util.List;

public interface PendingCaseWritePlatformService {
    List<PendingCaseData> fetchAllPendingCaseData();
    List<PendingCaseData> fetchByLfourPendingCase();

}
