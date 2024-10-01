package com.ponsun.pep.pepDetails.CommonAPI.service;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.CommonAPI.PepDetailsReadDTO;
import org.springframework.web.multipart.MultipartFile;

public interface CommonWriteService {
    Response saveCustomer(String pepDTO,MultipartFile[] files,MultipartFile[] files1,MultipartFile[]
            files2,MultipartFile[] files3,MultipartFile[] files4,
                          Integer[] pathIds,Integer[]  pathIds1,
                          Integer[]  pathIds2,Integer[]  pathIds3,Integer[] pathIds4, String[] cinfcrn,
                          MultipartFile[] companyfiles,Integer[] companyfilesPathId);

    Response updateCustomer(
            Integer euid,Integer pepId,
            MultipartFile[] files,
            MultipartFile[] files1,
            MultipartFile[] files2,
            MultipartFile[] files3,
            MultipartFile[] files4,
            Integer[] pathIds,
            Integer[] pathIds1,
            Integer[] pathIds2,
            Integer[] pathIds3,
            Integer[] pathIds4,
            String pepDTO,
            String[] cinfcrn,
            MultipartFile[] companyfiles,
            Integer[] companyfilesPathId
    );
    PepDetailsReadDTO getCompanyActivity(
            Integer pepId
    );

}
