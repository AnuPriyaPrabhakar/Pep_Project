package com.ponsun.pep.reports.QcPendingDt.services;

import com.ponsun.pep.reports.QcPendingDt.data.QcPendingDtData;

import java.util.List;

public interface QcPendingDtWritePlatformService {
    List<QcPendingDtData> fetchAllQcPendingDtData(String fromDate, String toDate);
}
