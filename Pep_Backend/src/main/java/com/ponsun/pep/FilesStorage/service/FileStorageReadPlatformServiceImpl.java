package com.ponsun.pep.FilesStorage.service;

import com.ponsun.pep.FilesStorage.domain.FileStorage;
import com.ponsun.pep.FilesStorage.domain.FileStorageRepository;
import com.ponsun.pep.FilesStorage.domain.FileStorageRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.services.CompanyDocumentsWritePlatformService;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.services.FamilyDocumentsReadPlatformService;
import com.ponsun.pep.relativeDetails.FamilyDocuments.services.FamilyDocumentsWritePlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageReadPlatformServiceImpl implements FileStorageReadPlatformService {
    private final FileStorageRepositoryWrapper fileStorageRepositoryWrapper;
    private final CompanyDocumentsWritePlatformService companyDocumentsWritePlatformService;
    private final JdbcTemplate jdbcTemplate;
    private final FileStorageRepository fileStorageRepository;
    private final Path root = Paths.get("D:\\uploadImages");
    private final String baseRoot = "D:\\uploadImages";

    @Override
    public FileStorage fetchFileStorageById(Integer id) {
        return this.fileStorageRepository.findById(id).get();

    }

    @Override
    public List<FileStorage> fetchAllFileStorage() {
        return this.fileStorageRepository.findAll();
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    private final FamilyDocumentsWritePlatformService familyDocumentsWritePlatformService;
    private final FamilyDocumentsReadPlatformService familyDocumentsReadPlatformService;


    @Override
    public List<String> getCompanyFiles(Integer companyId){
        try {
            String query = "SELECT CONCAT(url, '\\\\',id, '.', documentType) AS concatenated FROM pep_document_companies WHERE companyId=? AND STATUS='A'";
            List<String> filenames = jdbcTemplate.queryForList(query, String.class, companyId);

            System.out.println("Filenames: " + filenames);
            return filenames;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void renamed(Integer pepId, Integer pathId, MultipartFile files) {

        String resolvedRootDirectory = "";

        if (pathId == 1) {
            resolvedRootDirectory = "family\\profile";
        } else if (pathId == 2) {
            resolvedRootDirectory = "family\\party";
        } else if (pathId == 3) {
            resolvedRootDirectory = "companyDIN";
        } else if (pathId == 4) {
            resolvedRootDirectory = "companiesLLP";
        } else if (pathId == 7) {
            resolvedRootDirectory = "Others";
        }


        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        String documentType = getDocument(pepId, pathId);

        String fileExtension = documentType.substring(documentType.lastIndexOf(".") + 1);
        String fileExtensions = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".") + 1);

        System.out.println("documentType: "+documentType);

        System.out.println("fileExtensions: "+fileExtensions);

        String fileName = pepId + "." + fileExtension;
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyyy-MM-dd-HH-mm-ss"));
        File originalFile = new File(root + "\\" + fileName);
        File newFile = new File(root + "\\" + pepId + datetime + "." + fileExtension);

        try {
            boolean renamed = originalFile.renameTo(newFile);

            CreateFamilyDocumentsRequest createFamilyDocumentsRequest = new CreateFamilyDocumentsRequest();
            createFamilyDocumentsRequest.setDocumentType(fileExtensions);
            createFamilyDocumentsRequest.setPathId(pathId);
            createFamilyDocumentsRequest.setPepId(pepId);
            createFamilyDocumentsRequest.getUid();

            Files.createDirectories(root);
            String newFileName = pepId + "." + fileExtensions;
            Files.copy(files.getInputStream(), root.resolve(newFileName), StandardCopyOption.REPLACE_EXISTING);
            updateDocument(pepId,pathId);

            if (renamed) {
                System.out.println("File renamed successfully to: " + newFileName);
                // Move the file only if it has been successfully renamed
                if (originalFile.exists()) {
                    Files.move(originalFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File moved successfully to: " + newFile);
                } else {
                    System.err.println("Original file not found." + originalFile);
                }
            } else {
                System.err.println("File renaming failed.");
            }

            this.familyDocumentsWritePlatformService.createFamilyDocuments(createFamilyDocumentsRequest);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getDocument(Integer pepId, Integer pathId) {
        try {
            String sql = "select documentType from pep_document_family where pepId=? AND pathId=? AND status='A'";
            String documentType = jdbcTemplate.queryForObject(sql, String.class, pepId, pathId);
            return documentType;

        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public void updateDocument(Integer pepId, Integer pathId) {
        try {
            String sql = "update pep_document_family set status = 'D', updated_at = NOW() WHERE pepId = ? AND pathId = ? AND status = 'A'";
            jdbcTemplate.update(sql, pepId, pathId);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
    }



    @Override
    public void save(MultipartFile file, int pepId, Integer pathId) {
        String resolvedRootDirectory = "";

        if (pathId == 1) {
            resolvedRootDirectory = "family\\profile";
        } else if (pathId == 2) {
            resolvedRootDirectory = "family\\party";
        } else if (pathId == 3) {
            resolvedRootDirectory = "companyDIN";
        } else if (pathId == 4) {
            resolvedRootDirectory = "companiesLLP";
        }

        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        try {
            Files.createDirectories(root);

            String fileExtensions = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            CreateFamilyDocumentsRequest createFamilyDocumentsRequest = new CreateFamilyDocumentsRequest();
            createFamilyDocumentsRequest.setDocumentType(fileExtensions);
            createFamilyDocumentsRequest.setPathId(pathId);
            createFamilyDocumentsRequest.setPepId(pepId);
            createFamilyDocumentsRequest.getUid();

            String filename = pepId + "." + fileExtensions;
            Files.copy(file.getInputStream(), root.resolve(filename));
            this.familyDocumentsWritePlatformService.createFamilyDocuments(createFamilyDocumentsRequest);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public byte[] load(String fileName, String filePath) throws IOException {
        Path path = Paths.get(filePath, fileName);

        return Files.readAllBytes(path);
    }

    @Override
    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
