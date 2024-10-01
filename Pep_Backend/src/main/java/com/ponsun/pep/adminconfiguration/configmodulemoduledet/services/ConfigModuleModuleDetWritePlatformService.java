package com.ponsun.pep.adminconfiguration.configmodulemoduledet.services;


import com.ponsun.pep.adminconfiguration.configmodulemoduledet.data.ConfigModuleModuleDetData;

import java.util.List;

public interface ConfigModuleModuleDetWritePlatformService {
    List<ConfigModuleModuleDetData> fetchAllListofAlertData();
}
