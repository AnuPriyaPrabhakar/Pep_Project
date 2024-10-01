package com.ponsun.pep.Edit.ManagerPending.services;

import com.ponsun.pep.Edit.ManagerPending.data.QcManagerPendingData;

import java.util.List;

public interface QcManagerPendingWritePlatformService {

    List<QcManagerPendingData> fetchAllQcManagerPendingData(String fromDate, String toDate);
}
