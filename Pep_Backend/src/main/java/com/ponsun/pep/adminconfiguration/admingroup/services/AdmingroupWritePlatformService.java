package com.ponsun.pep.adminconfiguration.admingroup.services;


import com.ponsun.pep.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.pep.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface AdmingroupWritePlatformService {

    Response createAdmingroup(CreateAdmingroupRequest createAdmingroupRequest);
    Response updateAdmingroup(Integer id, UpdateAdmingroupRequest updateAdmingroupRequest);
    Response blockAdmingroup(Integer id);
    Response unblockAdmingroup(Integer id);


}
