package com.ponsun.pep.dinEdit.services;

import com.ponsun.pep.dinEdit.data.DinEditData;
import com.ponsun.pep.dinEdit.request.CreateDinEditRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface DinEditWritePlatformService {
    List <DinEditData> fetchAllDinName(String din);
    Response createDinEdit(CreateDinEditRequest createDinEditRequest);
}
