package com.ponsun.pep.Edit.ManagerViewPending.services;




import com.ponsun.pep.Edit.ManagerViewPending.data.ManagerViewPendingData;

import java.util.List;

public interface ManagerViewPendingReadPlatformService {

    List<ManagerViewPendingData> fetchAllManagerViewPendingData(String fromDate, String toDate);
}
