package com.ponsun.pep.adminconfiguration.adminconfigmodule.services;

import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;

import java.util.List;

public interface AdminConfigModuleReadPlatformService {
    AdminConfigModule fetchAdminConfigModuleById(Integer id);
    List<AdminConfigModule> fetchAllAdminConfigModule();
}