package com.ponsun.pep.Edit.QcPending.services;

import com.ponsun.pep.Edit.QcPending.data.QcPendingData;

import java.util.List;

public interface QcPendingWritePlatformService {



    List<QcPendingData> fetchAllQcPendingData(String fromDate, String toDate);
}
