package com.ponsun.pep.FilesStorage.api;

import com.ponsun.pep.FilesStorage.domain.FileStorage;
import com.ponsun.pep.FilesStorage.service.FileDownloadUtil;
import com.ponsun.pep.FilesStorage.service.FileStorageReadPlatformService;
import com.ponsun.pep.FilesStorage.service.FileStorageWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/FileUpload")
@Tag(name = "FileUploadApiResource")
public class FileController {
    private final FileStorageReadPlatformService fileStorageReadPlatformService;
    private final FileStorageWritePlatformService fileStorageWritePlatformService;
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String homepage() {
        return "redirect:/files";
    }

    @GetMapping("/files/new")
    public String newFile(Model model) {
        return "upload_form";
    }
    @GetMapping("/downloadCompanyFile/{companyId}")
    public ResponseEntity<?> downloadCompanyFile(
            @PathVariable("companyId") Integer companyId,
            @RequestParam("imageName") String imageName,
            @RequestParam("pathId") Integer pathId) {

        FileDownloadUtil downloadUtil = new FileDownloadUtil();
        Resource resource = null;

        try {
            resource = (Resource) downloadUtil.getCompanyFileAsResource(companyId, imageName, pathId);
        } catch (IOException e) {
            return new ResponseEntity<>("Error occurred while retrieving the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    public String getDocument(Integer pepId, Integer pathId) {
        String sql = "select id from pep_document_family where pepId=? AND pathId=? AND status='A'";
        List<String> results = jdbcTemplate.query(sql, new Object[]{pepId, pathId}, (rs, rowNum) -> rs.getString("id"));
        if (results.isEmpty()) {
            System.err.println("No document found with the given criteria.");
            return null;
        } else if (results.size() > 1) {
            System.err.println("More than one document found with the given criteria.");
            return null;
        } else {
            return results.get(0);
        }
    }

    @PutMapping("/blockDocument")
    public void blockDocument(@RequestParam Integer pepId, @RequestParam Integer pathId) {
        try {
            String sql = "UPDATE pep_document_family SET `status` = 'D' WHERE pepId = ? AND pathId = ? AND `status` = 'A';";
            jdbcTemplate.update(sql, pepId, pathId);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @GetMapping("/downloadFile/{pepId}")
    public ResponseEntity<?> downloadFile(@PathVariable("pepId") Integer pepId, Integer pathId) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        Resource resource = null;
        String imgId = getDocument(pepId, pathId);

        try {
            if (imgId != null) {
                resource = downloadUtil.getFileAsResource(imgId.toString(), pathId);
            }
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

//        String contentType = "application/octet-stream";
//        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        String contentType = "application/octet-stream";
        try {
            contentType = Files.probeContentType(Paths.get(resource.getFile().getAbsolutePath()));
        } catch (IOException e) {
            // Fallback to application/octet-stream
        }

        String headerValue = "attachment; filename=\"" + (resource.getFilename() != null ? resource.getFilename() : "unknown_file") + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    @PutMapping("/rename/{euid}")
    public ResponseEntity<String> renameFile(Integer pepId, @RequestParam("pathId") Integer[] pathIds, @RequestParam("files") MultipartFile[] files) {

        List<String> messages = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();

        for (int j = 0; j < files.length; j++) {
            MultipartFile file = files[j];
            int pathId = pathIds[j];
            try {
                fileStorageReadPlatformService.renamed(pepId, pathId, file);
            } catch (Exception e) {
            }
        }

        return ResponseEntity.ok("File renamed for: " + pepId + " - " + messages.toString());
    }


    @GetMapping("/fileget")
    public List<FileStorage> fetchAll() {
        return this.fileStorageReadPlatformService.fetchAllFileStorage();
    }

    @GetMapping("/{id}")
    public FileStorage fetchFileStorageById(@PathVariable Integer id) {
        return this.fileStorageReadPlatformService.fetchFileStorageById(id);
    }

    @PostMapping("/files/upload")
    public ResponseEntity<String> uploadFiles(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("files1") MultipartFile[] files1,
            @RequestParam("files2") MultipartFile[] files2,
            @RequestParam("files3") MultipartFile[] files3,
            @RequestParam("pathId") Integer[] pathId,
            @RequestParam("pathId1") Integer[] pathId1,
            @RequestParam("pathId2") Integer[] pathId2,
            @RequestParam("pathId3") Integer[] pathId3,

            Integer pepId,
            Integer associatedCompaniesId,
            Integer Id
    ) {
        List<String> messages = new ArrayList<>();
        try {
            for (int j = 0; j < files.length; j++) {
                fileStorageReadPlatformService.save(files[j], pepId, pathId[j]);
                messages.add(files[j].getOriginalFilename() + " [Successful]");
            }

            for (int j = 0; j < files1.length; j++) {
                fileStorageReadPlatformService.save(files1[j], pepId, pathId1[j]);
                messages.add(files1[j].getOriginalFilename() + " [Successful]");
            }

            for (int j = 0; j < files2.length; j++) {
                fileStorageReadPlatformService.save(files2[j], pepId, pathId2[j]);
                messages.add(files2[j].getOriginalFilename() + " [Successful]");
            }
            for (int j = 0; j < files3.length; j++) {
                fileStorageReadPlatformService.save(files3[j], pepId, pathId3[j]);
                messages.add(files2[j].getOriginalFilename() + " [Successful]");
            }

            return ResponseEntity.ok(messages.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/files/companysave")
    public ResponseEntity<String> uploadFiles(
            @RequestParam("files") MultipartFile[] companyfiles,
            @RequestParam("pathId") Integer[] companyfilesPathId,
            @RequestParam("associatedId") Integer[] associatedIds, @RequestParam("companyId") Integer[] companyIds) {

        if (companyfiles == null || companyfiles.length == 0) {
            return ResponseEntity.badRequest().body("No files received.");
        }

        System.out.println("Path IDs: " + Arrays.toString(companyfilesPathId));
        System.out.println("Associated IDs: " + Arrays.toString(associatedIds));

        List<String> messages = new ArrayList<>();
        try {
            for (int j = 0; j < companyfiles.length; j++) {
                System.out.println("Processing file: " + companyfiles[j].getOriginalFilename());

                fileStorageWritePlatformService.companyEdit(companyfiles[j], companyfilesPathId[j], associatedIds[j], companyIds[j]);
                messages.add(companyfiles[j].getOriginalFilename() + " [Successful]");
            }
            return ResponseEntity.ok("Files uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files.");
        }
    }

    @PutMapping("/Block/{id}")
    public ResponseEntity<String> blockCompanyDocument(@PathVariable("id") Integer id) {
        try {
            // Call service to update document status
            fileStorageWritePlatformService.blockCompanyDocument(id);
            return ResponseEntity.ok("Document blocked successfully.");
        } catch (DataAccessException e) {
            // Return error response with status 500
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error blocking the document.");
        }
    }

}

//package com.ponsun.pep.FilesStorage.api;
//
//import com.ponsun.pep.FilesStorage.domain.FileStorage;
//import com.ponsun.pep.FilesStorage.service.FileDownloadUtil;
//import com.ponsun.pep.FilesStorage.service.FileStorageReadPlatformService;
//import com.ponsun.pep.FilesStorage.service.FileStorageWritePlatformService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.Resource;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//@RestController
//@Slf4j
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/FileUpload")
//@Tag(name = "FileUploadApiResource")
//public class FileController {
//    private final FileStorageReadPlatformService fileStorageReadPlatformService;
//    private final FileStorageWritePlatformService fileStorageWritePlatformService;
//    private final JdbcTemplate jdbcTemplate;
//
//    @GetMapping("/")
//    public String homepage() {
//        return "redirect:/files";
//    }
//
//    @GetMapping("/files/new")
//    public String newFile(Model model) {
//        return "upload_form";
//    }
//    @GetMapping("/downloadCompanyFile/{companyId}")
//    public ResponseEntity<?> downloadCompanyFile(
//            @PathVariable("companyId") Integer companyId,
//            @RequestParam("imageName") String imageName,
//            @RequestParam("pathId") Integer pathId) {
//
//        FileDownloadUtil downloadUtil = new FileDownloadUtil();
//        Resource resource = null;
//
//        try {
//            resource = (Resource) downloadUtil.getCompanyFileAsResource(companyId, imageName, pathId);
//        } catch (IOException e) {
//            return new ResponseEntity<>("Error occurred while retrieving the file", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        if (resource == null) {
//            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
//        }
//        String contentType = "application/octet-stream";
//        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
//                .body(resource);
//    }
//
//    public String getDocument(Integer pepId, Integer pathId) {
//        String sql = "select id from pep_document_family where pepId=? AND pathId=? AND status='A'";
//        List<String> results = jdbcTemplate.query(sql, new Object[]{pepId, pathId}, (rs, rowNum) -> rs.getString("id"));
//        if (results.isEmpty()) {
//            System.err.println("No document found with the given criteria.");
//            return null;
//        } else if (results.size() > 1) {
//            System.err.println("More than one document found with the given criteria.");
//            return null;
//        } else {
//            return results.get(0);
//        }
//    }
//
//    @PutMapping("/blockDocument")
//    public void blockDocument(@RequestParam Integer pepId, @RequestParam Integer pathId) {
//        try {
//            String sql = "UPDATE pep_document_family SET `status` = 'D' WHERE pepId = ? AND pathId = ? AND `status` = 'A';";
//            jdbcTemplate.update(sql, pepId, pathId);
//        } catch (DataAccessException e) {
//            System.err.println("Error updating the document: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    @GetMapping("/downloadFile/{pepId}")
//    public ResponseEntity<?> downloadFile(@PathVariable("pepId") Integer pepId, Integer pathId) {
//        FileDownloadUtil downloadUtil = new FileDownloadUtil();
//
//        Resource resource = null;
//        String imgId = getDocument(pepId, pathId);
//
//        try {
//            if (imgId != null) {
//                resource = downloadUtil.getFileAsResource(imgId.toString(), pathId);
//            }
//        } catch (IOException e) {
//            return ResponseEntity.internalServerError().build();
//        }
//
//        if (resource == null) {
//            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
//        }
//
//        String contentType = "application/octet-stream";
//        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
//
//
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
//                .body(resource);
//    }
//
//    @PutMapping("/rename/{euid}")
//    public ResponseEntity<String> renameFile(Integer pepId, @RequestParam("pathId") Integer[] pathIds, @RequestParam("files") MultipartFile[] files) {
//
//        List<String> messages = new ArrayList<>();
//        AtomicInteger i = new AtomicInteger();
//
//        for (int j = 0; j < files.length; j++) {
//            MultipartFile file = files[j];
//            int pathId = pathIds[j];
//            try {
//                fileStorageReadPlatformService.renamed(pepId, pathId, file);
//            } catch (Exception e) {
//            }
//        }
//
//        return ResponseEntity.ok("File renamed for: " + pepId + " - " + messages.toString());
//    }
//
//    @GetMapping("/fileget")
//    public List<FileStorage> fetchAll() {
//        return this.fileStorageReadPlatformService.fetchAllFileStorage();
//    }
//
//    @GetMapping("/{id}")
//    public FileStorage fetchFileStorageById(@PathVariable Integer id) {
//        return this.fileStorageReadPlatformService.fetchFileStorageById(id);
//    }
//    @PostMapping("/files/upload")
//    public ResponseEntity<String> uploadFiles(
//            @RequestParam("files") MultipartFile[] files,
//            @RequestParam("files1") MultipartFile[] files1,
//            @RequestParam("files2") MultipartFile[] files2,
//            @RequestParam("files3") MultipartFile[] files3,
//            @RequestParam("pathId") Integer[] pathId,
//            @RequestParam("pathId1") Integer[] pathId1,
//            @RequestParam("pathId2") Integer[] pathId2,
//            @RequestParam("pathId3") Integer[] pathId3,
//
//            Integer pepId,
//            Integer associatedCompaniesId,
//            Integer Id
//    ) {
//        List<String> messages = new ArrayList<>();
//        try {
//            for (int j = 0; j < files.length; j++) {
//                fileStorageReadPlatformService.save(files[j], pepId, pathId[j]);
//                messages.add(files[j].getOriginalFilename() + " [Successful]");
//            }
//
//            for (int j = 0; j < files1.length; j++) {
//                fileStorageReadPlatformService.save(files1[j], pepId, pathId1[j]);
//                messages.add(files1[j].getOriginalFilename() + " [Successful]");
//            }
//
//            for (int j = 0; j < files2.length; j++) {
//                fileStorageReadPlatformService.save(files2[j], pepId, pathId2[j]);
//                messages.add(files2[j].getOriginalFilename() + " [Successful]");
//            }
//            for (int j = 0; j < files3.length; j++) {
//                fileStorageReadPlatformService.save(files3[j], pepId, pathId3[j]);
//                messages.add(files2[j].getOriginalFilename() + " [Successful]");
//            }
//
//            return ResponseEntity.ok(messages.toString());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/files/companysave")
//    public ResponseEntity<String> uploadFiles(
//            @RequestParam("files") MultipartFile[] companyfiles,
//            @RequestParam("pathId") Integer[] companyfilesPathId,
//            @RequestParam("associatedId") Integer[] associatedIds, @RequestParam("companyId") Integer[] companyIds) {
//
//        if (companyfiles == null || companyfiles.length == 0) {
//            return ResponseEntity.badRequest().body("No files received.");
//        }
//
//        System.out.println("Path IDs: " + Arrays.toString(companyfilesPathId));
//        System.out.println("Associated IDs: " + Arrays.toString(associatedIds));
//
//        List<String> messages = new ArrayList<>();
//        try {
//            for (int j = 0; j < companyfiles.length; j++) {
//                System.out.println("Processing file: " + companyfiles[j].getOriginalFilename());
//
//                fileStorageWritePlatformService.companyEdit(companyfiles[j], companyfilesPathId[j], associatedIds[j], companyIds[j]);
//                messages.add(companyfiles[j].getOriginalFilename() + " [Successful]");
//            }
//            return ResponseEntity.ok("Files uploaded successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files.");
//        }
//    }
//
//    @PutMapping("/Block/{id}")
//    public ResponseEntity<String> blockCompanyDocument(@PathVariable("id") Integer id) {
//        try {
//            // Call service to update document status
//            fileStorageWritePlatformService.blockCompanyDocument(id);
//            return ResponseEntity.ok("Document blocked successfully.");
//        } catch (DataAccessException e) {
//            // Return error response with status 500
//            System.err.println("Error updating the document: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error blocking the document.");
//        }
//    }
//
//}
