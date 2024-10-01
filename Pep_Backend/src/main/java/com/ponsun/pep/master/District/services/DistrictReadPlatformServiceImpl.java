package com.ponsun.pep.master.District.services;

import com.ponsun.pep.master.District.domain.District;
import com.ponsun.pep.master.District.domain.DistrictRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DistrictReadPlatformServiceImpl implements DistrictReadPlatformService {

    private final DistrictRepository districtRepository;
    @Override
    public District fetchDistrictById (Integer id) {
        return this.districtRepository.findById(id).get();
    }
    @Override
    public List<District> fetchAllDistrict() {
        return this.districtRepository.findAll();
    }
}
