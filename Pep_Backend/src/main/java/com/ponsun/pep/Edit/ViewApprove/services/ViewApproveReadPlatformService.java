package com.ponsun.pep.Edit.ViewApprove.services;

import com.ponsun.pep.Edit.ViewApprove.data.ViewApproveData;

import java.util.List;

public interface ViewApproveReadPlatformService {

    List<ViewApproveData> fetchAllViewApproveData(String fromDate, String toDate);
}
