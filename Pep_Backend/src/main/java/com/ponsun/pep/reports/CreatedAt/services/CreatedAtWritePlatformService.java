package com.ponsun.pep.reports.CreatedAt.services;

import com.ponsun.pep.reports.CreatedAt.data.CreatedAtData;

import java.util.List;

public interface CreatedAtWritePlatformService {

    List<CreatedAtData> fetchAllCreatedAtData(String fromDate, String toDate);
}
