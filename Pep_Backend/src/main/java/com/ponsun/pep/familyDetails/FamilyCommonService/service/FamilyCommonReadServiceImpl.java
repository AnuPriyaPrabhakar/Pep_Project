package com.ponsun.pep.familyDetails.FamilyCommonService.service;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FatherDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.HufDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.MotherDTO;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetailsRepository;
import com.ponsun.pep.familyDetails.FatherDetails.services.FatherDetailsWritePlatFormService;
import com.ponsun.pep.familyDetails.HufDetails.data.HufDetailsData;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetailsRepository;
import com.ponsun.pep.familyDetails.HufDetails.services.HufDetailsWritePlatFormService;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetailsRepository;
import com.ponsun.pep.familyDetails.MotherDetails.services.MotherDetailsWritePlatformService;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyCommonReadServiceImpl implements FamilyCommonReadService {

    private final HufDetailsRepository hufDetailsRepository;
    private final FatherDetailsRepository fatherDetailsRepository;
    private final MotherDetailsRepository motherDetailsRepository;
    private final HufDetailsWritePlatFormService hufDetailsWritePlatFormService;
    private final FatherDetailsWritePlatFormService fatherDetailsWritePlatFormService;
    private final MotherDetailsWritePlatformService motherDetailsWritePlatformService;


    public List<FamilyCombinedDTO> getFamilyDetails(Integer pepId) {
        List<HufDetailsData> hufDetailsData = hufDetailsRepository.findByPepId(pepId);
        ModelMapper modelMapper = new ModelMapper();
        List<FamilyCombinedDTO> familyCombinedDTOList = new ArrayList<>();

            FamilyCombinedDTO familyCombinedDTO = new FamilyCombinedDTO();
            List<HufDTO>  hufDTOList = hufDetailsWritePlatFormService.fetchHufDTO(pepId);
            List<FatherDTO> fatherDTOList = fatherDetailsWritePlatFormService.fetchFatherDTO(pepId);
            List<MotherDTO> motherDTOList = motherDetailsWritePlatformService.fetchMotherDTO(pepId);

            familyCombinedDTO.setHufDTO(hufDTOList);
            familyCombinedDTO.setFatherDTOS(fatherDTOList);
            familyCombinedDTO.setMotherDTOS(motherDTOList);
            familyCombinedDTOList.add(familyCombinedDTO);

        return familyCombinedDTOList;
    }
}
