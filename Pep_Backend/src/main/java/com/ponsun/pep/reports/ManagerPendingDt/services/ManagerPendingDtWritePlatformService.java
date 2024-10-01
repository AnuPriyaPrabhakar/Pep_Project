package com.ponsun.pep.reports.ManagerPendingDt.services;

import com.ponsun.pep.reports.ManagerPendingDt.data.ManagerPendingDtData;

import java.util.List;

public interface ManagerPendingDtWritePlatformService {
    List<ManagerPendingDtData> fetchAllManagerPendingDtData(String fromDate, String toDate);
}
