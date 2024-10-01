package com.ponsun.pep.relativeDetails.FamilyDocuments.services;


import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocuments;
import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocumentsRepository;
import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocumentsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyDocumentsReadPlatformServiceImpl implements FamilyDocumentsReadPlatformService{

    private final FamilyDocumentsRepositoryWrapper familyDocumentsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final FamilyDocumentsRepository familyDocumentsRepository;


    @Override
    public List<FamilyDocuments> fetchAllFamilyDocuments() {
        return this.familyDocumentsRepository.findAll();
    }

    @Override
    public FamilyDocuments fetchFamilyDocumentsById(Integer id) {
        return this.familyDocumentsRepository.findById(id).get();
    }
}
