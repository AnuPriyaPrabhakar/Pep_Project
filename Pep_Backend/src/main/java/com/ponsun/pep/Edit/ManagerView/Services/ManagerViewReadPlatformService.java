package com.ponsun.pep.Edit.ManagerView.Services;

import com.ponsun.pep.Edit.ManagerView.data.ManagerViewData;

import java.util.List;

public interface ManagerViewReadPlatformService {

    List<ManagerViewData> fetchAllManagerViewData(String fromDate, String toDate);
}
