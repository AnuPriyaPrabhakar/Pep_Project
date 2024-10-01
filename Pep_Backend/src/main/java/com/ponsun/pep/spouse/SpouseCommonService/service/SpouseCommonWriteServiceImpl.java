package com.ponsun.pep.spouse.SpouseCommonService.service;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepository;
import com.ponsun.pep.relativeDetails.Relative.domain.Relative;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepository;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.services.RelativeWritePlatformService;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepository;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepository;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseCommonDTO;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseFatherDTO;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseHufDTO;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseMotherDTO;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetails;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetailsRepository;
import com.ponsun.pep.spouse.spouseDetails.request.CreateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.services.SpouseDetailsWritePlatformService;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFather;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFatherRepository;
import com.ponsun.pep.spouse.spouseFather.request.CreateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHuf;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHufRepository;
import com.ponsun.pep.spouse.spouseHuf.request.CreateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMother;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMotherRepository;
import com.ponsun.pep.spouse.spouseMother.request.CreateSpouseMotherRequest;
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
public class SpouseCommonWriteServiceImpl implements SpouseCommonWriteService {

    private final SpouseDetailsRepository spouseDetailsRepository;
    private final SpouseHufRepository spouseHufRepository;
    private final SpouseFatherRepository spouseFatherRepository;
    private final SpouseMotherRepository spouseMotherRepository;
    private final SpouseDetailsWritePlatformService spouseDetailsWritePlatformService;


    @Override
    @Transactional
    public Response createSpouseDetails(Integer pepId, List<SpouseCommonDTO> spouseCommonDTOS) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            for (SpouseCommonDTO dto : spouseCommonDTOS) {
                CreateSpouseDetailsRequest request = modelMapper.map(dto.getSpouseDetailsDTO(), CreateSpouseDetailsRequest.class);
                final SpouseDetails spouseDetails = SpouseDetails.create(request);
                if (!spouseDetails.getSpouseName().isEmpty())
                {
                    spouseDetails.setPepId(pepId);
                    this.spouseDetailsRepository.save(spouseDetails);
                    int detId = spouseDetails.getId();
                    response = Response.of(spouseDetails.getId());

                    for (SpouseHufDTO spouseHufDTO : dto.getSpouseHufDTOS()) {
                        CreateSpouseHufRequest spouseHufRequest = modelMapper.map(spouseHufDTO, CreateSpouseHufRequest.class);
                        if(!spouseHufRequest.getHufName().isEmpty()) {
                            spouseHufRequest.setSpouseId(detId);
                            spouseHufRequest.setPepId(pepId);
                            final SpouseHuf spouseHuf = SpouseHuf.create(spouseHufRequest);
                            this.spouseHufRepository.save(spouseHuf);
                        }
                    }
                    for (SpouseFatherDTO spouseFatherDTO : dto.getSpouseFatherDTOS()) {
                        CreateSpouseFatherRequest createSpouseFatherRequest = modelMapper.map(spouseFatherDTO, CreateSpouseFatherRequest.class);
                        if(!createSpouseFatherRequest.getFatherName().isEmpty()) {
                            createSpouseFatherRequest.setSpouseId(detId);
                            createSpouseFatherRequest.setPepId(pepId);
                            final SpouseFather spouseFather = SpouseFather.create(createSpouseFatherRequest);
                            this.spouseFatherRepository.save(spouseFather);
                        }
                    }

                    for (SpouseMotherDTO spouseMotherDTO : dto.getSpouseMotherDTOS()) {
                        CreateSpouseMotherRequest createSpouseMotherRequest = modelMapper.map(spouseMotherDTO, CreateSpouseMotherRequest.class);
                        if(!createSpouseMotherRequest.getMotherName().isEmpty()) {
                            createSpouseMotherRequest.setSpouseId(detId);
                            createSpouseMotherRequest.setPepId(pepId);
                            final SpouseMother spouseMother = SpouseMother.create(createSpouseMotherRequest);
                            this.spouseMotherRepository.save(spouseMother);
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
    public Response createAndUpdateSpouseDetails(Integer pepId, Integer euid, List<SpouseCommonDTO> spouseCommonDTOS) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();

            for (SpouseCommonDTO dto : spouseCommonDTOS) {
                this.spouseDetailsWritePlatformService.DeActiveSpouse(pepId, euid);
                CreateSpouseDetailsRequest request = modelMapper.map(dto.getSpouseDetailsDTO(), CreateSpouseDetailsRequest.class);
                if(!request.getSpouseName().isEmpty()) {
                    final SpouseDetails spouseDetails = SpouseDetails.create(request);
                    if (!spouseDetails.getSpouseName().isEmpty()) {
                        spouseDetails.setPepId(pepId);
                        this.spouseDetailsRepository.save(spouseDetails);
                        int detId = spouseDetails.getId();
                        response = Response.of(spouseDetails.getId());

                        for (SpouseHufDTO spouseHufDTO : dto.getSpouseHufDTOS()) {
                            CreateSpouseHufRequest spouseHufRequest = modelMapper.map(spouseHufDTO, CreateSpouseHufRequest.class);
                            if (!spouseHufRequest.getHufName().isEmpty()) {
                                spouseHufRequest.setSpouseId(detId);
                                spouseHufRequest.setPepId(pepId);
                                final SpouseHuf spouseHuf = SpouseHuf.create(spouseHufRequest);
                                this.spouseHufRepository.save(spouseHuf);
                            }
                        }
                        for (SpouseFatherDTO spouseFatherDTO : dto.getSpouseFatherDTOS()) {
                            CreateSpouseFatherRequest createSpouseFatherRequest = modelMapper.map(spouseFatherDTO, CreateSpouseFatherRequest.class);
                            if (!createSpouseFatherRequest.getFatherName().isEmpty()) {
                                createSpouseFatherRequest.setSpouseId(detId);
                                createSpouseFatherRequest.setPepId(pepId);
                                final SpouseFather spouseFather = SpouseFather.create(createSpouseFatherRequest);
                                this.spouseFatherRepository.save(spouseFather);
                            }
                        }
                        for (SpouseMotherDTO spouseMotherDTO : dto.getSpouseMotherDTOS()) {
                            CreateSpouseMotherRequest createSpouseMotherRequest = modelMapper.map(spouseMotherDTO, CreateSpouseMotherRequest.class);
                            if (!createSpouseMotherRequest.getMotherName().isEmpty()) {
                                createSpouseMotherRequest.setSpouseId(detId);
                                createSpouseMotherRequest.setPepId(pepId);
                                final SpouseMother spouseMother = SpouseMother.create(createSpouseMotherRequest);
                                this.spouseMotherRepository.save(spouseMother);
                            }
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
