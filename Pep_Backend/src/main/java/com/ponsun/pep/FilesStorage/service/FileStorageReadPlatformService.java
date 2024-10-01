package com.ponsun.pep.FilesStorage.service;

import com.ponsun.pep.FilesStorage.domain.FileStorage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FileStorageReadPlatformService {

    FileStorage fetchFileStorageById(Integer id);

    List<FileStorage> fetchAllFileStorage();

    public void init();

    byte[] load(String fileName, String filePath) throws IOException;

    void renamed(Integer pepId, Integer pathId, MultipartFile files);

    List<String> getCompanyFiles(Integer companyId);

    void save(MultipartFile file, int pepId, Integer pathId);

    public boolean delete(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

}
