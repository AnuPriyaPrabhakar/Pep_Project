package com.ponsun.pep.Edit.QcView.services;

import com.ponsun.pep.Edit.QcView.data.QcViewData;

import java.util.List;

public interface QcViewWritePlatformService {

    List<QcViewData> fetchAllQcViewData(String fromDate, String toDate);
}
