package com.ponsun.pep.reports.QcEditDt.services;

import com.ponsun.pep.reports.QcEditDt.data.QcEditDtData;

import java.util.List;

public interface QcEditDtWritePlatformService {
    List<QcEditDtData> fetchAllQcEditDtData(String fromDate, String toDate);
}
