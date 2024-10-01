package com.ponsun.pep.familyDetails.FamilyCommonService.service;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FamilyCombinedDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FatherDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.HufDTO;
import com.ponsun.pep.familyDetails.FamilyCommonService.dto.MotherDTO;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetails;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetailsRepository;
import com.ponsun.pep.familyDetails.FatherDetails.request.CreateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.services.FatherDetailsWritePlatFormService;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetails;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetailsRepository;
import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetails;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetailsRepository;
import com.ponsun.pep.familyDetails.MotherDetails.request.CreateMotherDetailsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyCommonWriteServiceImpl implements  FamilyCommonWriteService {

    private final HufDetailsRepository hufDetailsRepository;
    private final FatherDetailsRepository fatherDetailsRepository;
    private final MotherDetailsRepository motherDetailsRepository;
    private final FatherDetailsWritePlatFormService fatherDetailsWritePlatFormService;

    @Override
    @Transactional
    public Response createFamilyDetails(Integer pepId, List<FamilyCombinedDTO> familyCombinedDTOS) {
        try {
            Response response = new Response();
            ModelMapper modelMapper = new ModelMapper();
            for (FamilyCombinedDTO dto : familyCombinedDTOS) {
                {
                    for (HufDTO hufDTO : dto.getHufDTO()) {
                        CreateHufDetailsRequest hufDetailsRequest = modelMapper.map(hufDTO, CreateHufDetailsRequest.class);
                        if(!hufDetailsRequest.getHufName().isEmpty()) {
                            hufDetailsRequest.setPepId(pepId);
                            final HufDetails hufDetails1 = HufDetails.create(hufDetailsRequest);
                            this.hufDetailsRepository.save(hufDetails1);
                        }
                    }

                    for (FatherDTO fatherDTO : dto.getFatherDTOS()) {
                        CreateFatherDetailsRequest fatherDetailsRequest = modelMapper.map(fatherDTO, CreateFatherDetailsRequest.class);
                        if(!fatherDetailsRequest.getFatherName().isEmpty()) {
                            fatherDetailsRequest.setPepId(pepId);
                            final FatherDetails fatherDetails = FatherDetails.create(fatherDetailsRequest);
                            this.fatherDetailsRepository.save(fatherDetails);
                        }
                    }

                    for (MotherDTO motherDTO : dto.getMotherDTOS()) {
                        CreateMotherDetailsRequest createMotherDetailsRequest = modelMapper.map(motherDTO, CreateMotherDetailsRequest.class);
                        if(!createMotherDetailsRequest.getMotherName().isEmpty()) {
                            createMotherDetailsRequest.setPepId(pepId);
                            final MotherDetails motherDetails = MotherDetails.create(createMotherDetailsRequest);
                            this.motherDetailsRepository.save(motherDetails);
                        }
                    }
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response createAndUpdateFamilyDetails(Integer pepId, Integer euid, List<FamilyCombinedDTO> familyCombinedDTOS) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();

            for (FamilyCombinedDTO dto : familyCombinedDTOS) {
                {
                    this.fatherDetailsWritePlatFormService.DeActiveFamily(pepId, euid);
                    for (HufDTO hufDTO : dto.getHufDTO()) {
                        CreateHufDetailsRequest hufDetailsRequest = modelMapper.map(hufDTO, CreateHufDetailsRequest.class);
                        if(!hufDetailsRequest.getHufName().isEmpty()) {
                            hufDetailsRequest.setPepId(pepId);
                            final HufDetails hufDetails1 = HufDetails.create(hufDetailsRequest);
                            this.hufDetailsRepository.save(hufDetails1);
                        }
                    }

                    for (FatherDTO fatherDTO : dto.getFatherDTOS()) {
                        CreateFatherDetailsRequest fatherDetailsRequest = modelMapper.map(fatherDTO, CreateFatherDetailsRequest.class);
                        if(!fatherDetailsRequest.getFatherName().isEmpty()) {
                            fatherDetailsRequest.setPepId(pepId);
                            final FatherDetails fatherDetails = FatherDetails.create(fatherDetailsRequest);
                            this.fatherDetailsRepository.save(fatherDetails);
                        }
                    }
                    for (MotherDTO motherDTO : dto.getMotherDTOS()) {
                        CreateMotherDetailsRequest createMotherDetailsRequest = modelMapper.map(motherDTO, CreateMotherDetailsRequest.class);
                        if(!createMotherDetailsRequest.getMotherName().isEmpty()) {

                            createMotherDetailsRequest.setPepId(pepId);
                            final MotherDetails motherDetails = MotherDetails.create(createMotherDetailsRequest);
                            this.motherDetailsRepository.save(motherDetails);
                        }
                    }
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
