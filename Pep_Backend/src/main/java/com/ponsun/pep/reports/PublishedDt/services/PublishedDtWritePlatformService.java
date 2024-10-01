package com.ponsun.pep.reports.PublishedDt.services;

import com.ponsun.pep.reports.PublishedDt.data.PublishedDtData;

import java.util.List;

public interface PublishedDtWritePlatformService {
    List<PublishedDtData> fetchAllPublishedDtData(String fromDate, String toDate);
}
