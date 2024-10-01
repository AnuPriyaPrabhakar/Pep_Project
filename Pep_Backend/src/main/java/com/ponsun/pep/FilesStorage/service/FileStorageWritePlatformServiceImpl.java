package com.ponsun.pep.FilesStorage.service;

import com.ponsun.pep.FilesStorage.domain.FileStorage;
import com.ponsun.pep.FilesStorage.domain.FileStorageRepository;
import com.ponsun.pep.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.CreateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.services.CompanyDocumentsWritePlatformService;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.CreatePartyCandidateDetailsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.services.FamilyDocumentsWritePlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageWritePlatformServiceImpl implements FileStorageWritePlatformService {
    private final FileStorageRepository fileStorageRepository;
    private final FamilyDocumentsWritePlatformService familyDocumentsWritePlatformService;
    private final CompanyDocumentsWritePlatformService companyDocumentsWritePlatformService;
    private final JdbcTemplate jdbcTemplate;

    private final String baseRoot = "D:\\uploadImages";

    @Override
    @Transactional
    public Response createFileStorage(CreateFileStorageRequest createFileStorageRequest) {
        try {
            final FileStorage fileStorage = FileStorage.create(createFileStorageRequest);
            this.fileStorageRepository.saveAndFlush(fileStorage);
            return Response.of(fileStorage.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
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
        } else if (pathId == 7) {
            resolvedRootDirectory = "Others";
        }

        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        if (pepId!=0)
            updateFamilyDocument(pepId,pathId);

        try {
            Files.createDirectories(root);

            String fileExtensions = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            CreatePartyCandidateDetailsRequest createPartyRequest = new CreatePartyCandidateDetailsRequest();
            Integer uId = createPartyRequest.getUid();
            CreateFamilyDocumentsRequest createFamilyDocumentsRequest = new CreateFamilyDocumentsRequest();
            createFamilyDocumentsRequest.setDocumentType(fileExtensions);
            createFamilyDocumentsRequest.setPathId(pathId);
            createFamilyDocumentsRequest.setPepId(pepId);
            createFamilyDocumentsRequest.setUid(uId);

            Response response = this.familyDocumentsWritePlatformService.createFamilyDocuments(createFamilyDocumentsRequest);
            Integer imageId = (Integer) response.getId();
            System.out.println("imageId: "+imageId);

            String filename = imageId + "." + fileExtensions;
            Files.copy(file.getInputStream(), root.resolve(filename));
            System.out.println("filename: "+filename);

        } catch (IOException e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Filename already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateFamilyDocument(Integer pepId,Integer pathId) {
        try {
//            String sql = "update pep_document_family set status = 'D', updated_at = NOW() WHERE id = ? AND status = 'A'";
//            jdbcTemplate.update(sql, imgId);
            String sql = "UPDATE pep_document_family SET `status` = 'D' WHERE pepId = ? AND pathId = ? AND `status` = 'A';";
            jdbcTemplate.update(sql, pepId, pathId);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void companysave(MultipartFile companyfiles, int companyfilesPathId, Integer AssociatedId) {
        String resolvedRootDirectory = "";

        int pathId = companyfilesPathId;

        if (pathId == 5) {
            resolvedRootDirectory = "about_companyDetails";
        } else if (pathId == 6) {
            resolvedRootDirectory = "DirectorsList";
        }
        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        updatecompanyDocument(AssociatedId);
        try {

            String fileExtensions = "";
            fileExtensions = companyfiles.getOriginalFilename().substring(companyfiles.getOriginalFilename().lastIndexOf(".") + 1);
            System.out.println("fileExtensions :" + fileExtensions);

            String folderName = AssociatedId.toString();
            Path folderPath = root.resolve(folderName);
            Files.createDirectories(folderPath);
            System.out.println("File saved: " + folderPath);

            CreateCompanyDocumentsRequest createCompanyDocumentsRequest = new CreateCompanyDocumentsRequest();
            createCompanyDocumentsRequest.setCompanyId(AssociatedId);
            createCompanyDocumentsRequest.setPathId(pathId);
            createCompanyDocumentsRequest.setDocumentType(fileExtensions);
            createCompanyDocumentsRequest.setUid(1);
            createCompanyDocumentsRequest.setUrl(folderPath.toString());

            Response response = this.companyDocumentsWritePlatformService.saveCompanyDocuments(createCompanyDocumentsRequest);
            Integer imageId = (Integer) response.getId();

            String filename = imageId + "." + fileExtensions;
            Files.copy(companyfiles.getInputStream(), folderPath.resolve(filename));

        } catch (NullPointerException e) {
            throw new RuntimeException("File storage service is currently unavailable. Please try again later.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void updatecompanyDocument(Integer id) {
        try {
            String sql = "UPDATE `pep_document_companies` SET STATUS = 'D', updated_at = NOW() WHERE id = ?";
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void blockCompanyDocument(Integer id) {
        try {
            String sql = "UPDATE pep_document_companies SET status = 'D', updated_at = NOW() WHERE id = ?";
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            throw e; // Rethrow the exception to be handled by the controller
        }
    }

    @Override
    @Transactional
    public void companyEdit(MultipartFile companyfiles, int companyfilesPathId, Integer AssociatedId, Integer companyIds) {
        String resolvedRootDirectory = "";

        int pathId = companyfilesPathId;

        if (pathId == 5) {
            resolvedRootDirectory = "about_companyDetails";
        } else if (pathId == 6) {
            resolvedRootDirectory = "DirectorsList";
        }
        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        updatecompanyDocument(AssociatedId);
        try {

            String fileExtensions = "";
            fileExtensions = companyfiles.getOriginalFilename().substring(companyfiles.getOriginalFilename().lastIndexOf(".") + 1);
            System.out.println("fileExtensions :" + fileExtensions);

            String folderName = companyIds.toString();
            Path folderPath = root.resolve(folderName);
            Files.createDirectories(folderPath);
            System.out.println("File saved: " + folderPath);

            CreateCompanyDocumentsRequest createCompanyDocumentsRequest = new CreateCompanyDocumentsRequest();
            createCompanyDocumentsRequest.setCompanyId(companyIds);
            createCompanyDocumentsRequest.setPathId(pathId);
            createCompanyDocumentsRequest.setDocumentType(fileExtensions);
            createCompanyDocumentsRequest.setUid(1);
            createCompanyDocumentsRequest.setUrl(folderPath.toString());

            Response response = this.companyDocumentsWritePlatformService.saveCompanyDocuments(createCompanyDocumentsRequest);
            Integer imageId = (Integer) response.getId();

            String filename = imageId + "." + fileExtensions;
            Files.copy(companyfiles.getInputStream(), folderPath.resolve(filename));

        } catch (NullPointerException e) {
            throw new RuntimeException("File storage service is currently unavailable. Please try again later.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

