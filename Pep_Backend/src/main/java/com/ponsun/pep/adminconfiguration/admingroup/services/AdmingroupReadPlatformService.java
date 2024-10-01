package com.ponsun.pep.adminconfiguration.admingroup.services;

import com.ponsun.pep.adminconfiguration.admingroup.domain.Admingroup;

import java.util.List;

public interface AdmingroupReadPlatformService {
    Admingroup fetchAdmingroupById(Integer id);
    List<Admingroup> fetchAllAdmingroup();



}