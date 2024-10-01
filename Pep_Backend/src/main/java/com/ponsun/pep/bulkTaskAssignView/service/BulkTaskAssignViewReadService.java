package com.ponsun.pep.bulkTaskAssignView.service;



import com.ponsun.pep.bulkTaskAssignView.data.BulkTaskAssignViewData;

import java.util.List;

public interface BulkTaskAssignViewReadService {
    List<BulkTaskAssignViewData> fetchAllBulkTaskAssignView(Integer uid);
}
