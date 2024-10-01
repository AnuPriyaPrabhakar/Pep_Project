package com.ponsun.pep.FilesStorage.service;

import com.ponsun.pep.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageWritePlatformService {
    Response createFileStorage(CreateFileStorageRequest createFileStorageRequest);
    void save(MultipartFile file, int pepId, Integer pathId);
    void companysave(MultipartFile companyfiles, int companyfilesPathId, Integer AssociatedId);

    void blockCompanyDocument(Integer id);

    void companyEdit(MultipartFile companyfiles, int companyfilesPathId, Integer AssociatedId, Integer companyIds);
}
