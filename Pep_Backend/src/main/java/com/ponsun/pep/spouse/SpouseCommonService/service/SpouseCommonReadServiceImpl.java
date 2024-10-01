package com.ponsun.pep.spouse.SpouseCommonService.service;

import com.ponsun.pep.spouse.SpouseCommonService.dto.*;
import com.ponsun.pep.spouse.spouseDetails.data.SpouseDetailsData;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetailsRepository;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFatherRepository;
import com.ponsun.pep.spouse.spouseFather.services.SpouseFatherWritePlatformService;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHufRepository;
import com.ponsun.pep.spouse.spouseHuf.services.SpouseHufWritePlatformService;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMotherRepository;
import com.ponsun.pep.spouse.spouseMother.services.SpouseMotherWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SpouseCommonReadServiceImpl implements  SpouseCommonReadService {

    private final SpouseDetailsRepository spouseDetailsRepository;
    private final SpouseHufRepository spouseHufRepository;
    private final SpouseFatherRepository spouseFatherRepository;
    private final SpouseMotherRepository spouseMotherRepository;
    private final SpouseHufWritePlatformService spouseHufWritePlatformService;
    private final SpouseFatherWritePlatformService spouseFatherWritePlatformService;
    private final SpouseMotherWritePlatformService spouseMotherWritePlatformService;
    public List<SpouseCommonDTO> getSpouseDetails(Integer pepId) {
        List<SpouseDetailsData> spouseDetailsDataList = spouseDetailsRepository.findByPepId(pepId);
        ModelMapper modelMapper = new ModelMapper();
        List<SpouseCommonDTO> spouseCommonDTOSList = new ArrayList<>();

        for(SpouseDetailsData spouseDetailsData : spouseDetailsDataList) {
            SpouseCommonDTO spouseCommonDTO = new SpouseCommonDTO();
            SpouseDetailsDTO spouseDetailsDTO = modelMapper.map(spouseDetailsData , SpouseDetailsDTO.class);
            Integer spouseId  = spouseDetailsDTO.getId();
            List<SpouseHufDTO> spouseHufDTOList = spouseHufWritePlatformService.fetchSpouseHufDTO(pepId,spouseId);
            List<SpouseFatherDTO> spouseFatherDTOList = spouseFatherWritePlatformService.fetchSpouseFatherDTO(pepId,spouseId);
            List<SpouseMotherDTO> spouseMotherDTOList = spouseMotherWritePlatformService.fetchSpouseMotherDTO(pepId,spouseId);

            spouseCommonDTO.setSpouseDetailsDTO(spouseDetailsDTO);
            spouseCommonDTO.setSpouseHufDTOS(spouseHufDTOList);
            spouseCommonDTO.setSpouseFatherDTOS(spouseFatherDTOList);
            spouseCommonDTO.setSpouseMotherDTOS(spouseMotherDTOList);
            spouseCommonDTOSList.add(spouseCommonDTO);
        }
        return spouseCommonDTOSList;
    }
}

