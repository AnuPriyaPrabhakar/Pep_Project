package com.ponsun.pep.reports.TaskAssignReport.services;

import com.ponsun.pep.reports.TaskAssignReport.data.TaskAssignReportData;

import java.util.List;

public interface TaskAssignReportWritePlatformService {
    List<TaskAssignReportData> fetchAllTaskAssignReportData(String fromDate, String toDate);
}
