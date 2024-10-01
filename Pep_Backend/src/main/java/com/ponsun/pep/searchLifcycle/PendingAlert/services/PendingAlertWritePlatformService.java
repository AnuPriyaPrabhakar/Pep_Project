package com.ponsun.pep.searchLifcycle.PendingAlert.services;

import com.ponsun.pep.searchLifcycle.PendingAlert.data.PendingAlertData;

import java.util.List;

public interface PendingAlertWritePlatformService {
    List<PendingAlertData> fetchAllPendingAlertData(String levelId);
}
