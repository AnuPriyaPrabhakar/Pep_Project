package com.ponsun.pep.reports.ManagerAproveDt.services;

import com.ponsun.pep.reports.ManagerAproveDt.data.ManagerApproveDtData;

import java.util.List;

public interface ManagerApproveDtWritePlatformService {
    List<ManagerApproveDtData> fetchAllManagerApproveDtData(String fromDate, String toDate);
}
