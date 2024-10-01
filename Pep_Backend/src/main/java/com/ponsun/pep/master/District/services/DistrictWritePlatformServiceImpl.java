package com.ponsun.pep.master.District.services;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.District.data.DistrictDataValidator;
import com.ponsun.pep.master.District.domain.District;
import com.ponsun.pep.master.District.domain.DistrictRepository;
import com.ponsun.pep.master.District.domain.DistrictRepositoryWrapper;
import com.ponsun.pep.master.District.request.CreateDistrictRequest;
import com.ponsun.pep.master.District.request.UpdateDistrictRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class DistrictWritePlatformServiceImpl implements DistrictWritePlatformService {

    private final DistrictRepository districtRepository;
    private final DistrictRepositoryWrapper districtRepositoryWrapper;
    private final DistrictDataValidator districtDataValidator;
    public Response createDistrict(CreateDistrictRequest createDistrictRequest) {
        try {
            this.districtDataValidator.validateSaveDistrict(createDistrictRequest);
            final District district = District.create(createDistrictRequest);
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(district.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateDistrict(Integer id, UpdateDistrictRequest updateDistrictRequest) {
        try {
            this.districtDataValidator.validateUpdateDistrict(updateDistrictRequest);
            final District district = this.districtRepositoryWrapper.findOneWithNotFoundDetection(id);
            district.update(updateDistrictRequest);
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(district.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockDistrict(Integer id) {
        try {
            final District district = this.districtRepositoryWrapper.findOneWithNotFoundDetection(id);
            district.setStatus(Status.DELETE); // Or set the appropriate status
            district.setUpdatedAt(LocalDateTime.now());
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockDistrict(Integer id) {
        try {
            final District district = this.districtRepositoryWrapper.findOneWithNotFoundDetection(id);
            district.setStatus(Status.ACTIVE); // Or set the appropriate status
            district.setUpdatedAt(LocalDateTime.now());
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}

