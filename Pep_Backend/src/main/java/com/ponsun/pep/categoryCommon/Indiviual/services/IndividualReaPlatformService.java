package com.ponsun.pep.categoryCommon.Indiviual.services;

import com.ponsun.pep.categoryCommon.Indiviual.data.IndividualData;

import java.util.List;

public interface IndividualReaPlatformService {
    List<IndividualData> fetchAllIndividualData(String pepName);
}
