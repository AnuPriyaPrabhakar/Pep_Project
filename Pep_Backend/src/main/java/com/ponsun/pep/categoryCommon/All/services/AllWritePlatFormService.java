package com.ponsun.pep.categoryCommon.All.services;

import com.ponsun.pep.categoryCommon.All.data.AllData;

import java.util.List;

public interface AllWritePlatFormService {
    List<AllData> fetchAllAllData(String pepName);
}
