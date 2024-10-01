package com.ponsun.pep.adminconfiguration.adminconfigmoduledet.services;

import com.ponsun.pep.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDet;

import java.util.List;

public interface AdminConfigModuleDetReadPlatformService {

    AdminConfigModuleDet fetchAdminConfigModuleDetById(Integer id);
    List <AdminConfigModuleDet> fetchAllAdminConfigModuleDet();
}
