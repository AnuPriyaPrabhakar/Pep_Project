package com.ponsun.pep.reports.ReassignDt.services;

import com.ponsun.pep.reports.ReassignDt.data.ReassignDtData;

import java.util.List;

public interface ReassignDtWritePlatformService {
    List<ReassignDtData> fetchAllReassignDtData(String fromDate, String toDate);
}
