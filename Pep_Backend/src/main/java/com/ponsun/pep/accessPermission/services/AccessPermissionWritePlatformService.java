package com.ponsun.pep.accessPermission.services;

import com.ponsun.pep.accessPermission.data.AccessPermissionData;

import java.util.List;

public interface AccessPermissionWritePlatformService {
    List<AccessPermissionData> fetchAllAccessPermissionData(String uid);
}
