package com.ponsun.pep.master.designation.services;


import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.designation.request.CreateDesignationRequest;
import com.ponsun.pep.master.designation.request.UpdateDesignationRequest;

public interface DesignationWritePlatformService {
    Response createDesignation(CreateDesignationRequest createDesignationRequest);
    Response updateDesignation(Integer id, UpdateDesignationRequest updateDesignationRequest);


    Response blockDesignation(Integer id);

    Response unblockDesignation(Integer id);


}
