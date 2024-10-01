package com.ponsun.pep.master.AssociatedList.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.AssociatedList.request.CreateAssociatedListRequest;
import com.ponsun.pep.master.AssociatedList.request.UpdateAssociatedListRequest;

public interface AssociatedListWritePlatformService {
    Response createAssociatedList(CreateAssociatedListRequest createAssociatedListRequest);
    Response updateAssociatedList(Integer id, UpdateAssociatedListRequest updateAssociatedListRequest);
    Response blockAssociatedList(Integer id);
    Response unblockAssociatedList(Integer id);
}
