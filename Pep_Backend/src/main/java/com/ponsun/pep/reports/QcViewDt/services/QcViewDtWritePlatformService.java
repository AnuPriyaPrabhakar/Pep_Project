package com.ponsun.pep.reports.QcViewDt.services;

import com.ponsun.pep.reports.QcViewDt.data.QcViewDtData;

import java.util.List;

public interface QcViewDtWritePlatformService {
    List<QcViewDtData> fetchAllQcViewDtData(String fromDate, String toDate);
}
