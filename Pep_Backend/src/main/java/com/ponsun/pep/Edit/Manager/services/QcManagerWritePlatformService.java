package com.ponsun.pep.Edit.Manager.services;

import com.ponsun.pep.Edit.Manager.data.QcManagerData;

import java.util.List;

public interface QcManagerWritePlatformService {

    List<QcManagerData> fetchAllQcManagerData(String fromDate, String toDate);
}
