package com.ponsun.pep.firstInFirstOut.services;
import com.ponsun.pep.firstInFirstOut.data.FirstInFirstOutData;


import java.util.List;

public interface FirstInFirstOutReadPlatformService {

    List<FirstInFirstOutData> getAllCustomersOrderedByIdDesc();
}
