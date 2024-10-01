package com.ponsun.pep.getDirectors.services;

import com.ponsun.pep.getDirectors.data.GetDirectorsData;

import java.util.List;

public interface GetDirectorsReadService {
    List<GetDirectorsData> fetchGetDirectorsData(String pan);
}
