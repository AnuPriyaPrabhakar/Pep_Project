package com.ponsun.pep.searchLifcycle.HitRecord.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordDataValidator;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecord;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecordRepository;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecordRepositoryWrapper;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import com.ponsun.pep.searchLifcycle.HitRecord.request.UpdateHitRecordRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HitRecordWritePlatformServiceImpl implements HitRecordWritePlatformService{
    private final HitRecordRepository hitRecordRepository;
    private final HitRecordRepositoryWrapper hitRecordRepositoryWrapper;
    private final HitRecordDataValidator hitRecordDataValidator;

    @Override
    @Transactional
    public Response createHitRecord(CreateHitRecordRequest createHitRecordRequest){
        try{
            this.hitRecordDataValidator.validateSaveHitData(createHitRecordRequest);
            final HitRecord hitRecord = HitRecord.create(createHitRecordRequest);
            this.hitRecordRepository.saveAndFlush(hitRecord);
            return Response.of(hitRecord.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<HitRecord> createlistodHitData(List<RecordDTO> uniqueListOfArrays,Integer uid) {
        try {
            List<HitRecord> hitRecords = uniqueListOfArrays.stream()
                    .map(recordDTO -> {
                        HitRecord hitRecord = new HitRecord();
                        hitRecord.setSearchId(recordDTO.getSearchId());
                        hitRecord.setCriminalId(recordDTO.getCriminalId());
                        hitRecord.setDisplay("P"+recordDTO.getIds());
                        hitRecord.setFileType(recordDTO.getFileType());
                        hitRecord.setMatchingScore(recordDTO.getScore());
                        hitRecord.setName(recordDTO.getNAME());
                        hitRecord.setCycleId(1);
                        hitRecord.setStatusNowId(0);
                        hitRecord.setValid(true);
                        hitRecord.setStatus(Status.ACTIVE);
                        hitRecord.setUid(uid);
                        return hitRecord;
                    }).collect(Collectors.toList());
            return this.hitRecordRepository.saveAll(hitRecords);
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateHitRecord(Integer id, UpdateHitRecordRequest updateHitRecordRequest){
        try{
            final HitRecord hitRecord = this.hitRecordRepositoryWrapper.findOneWithNotFoundDetection(id);
            hitRecord.update(updateHitRecordRequest);
            this.hitRecordRepository.saveAndFlush(hitRecord);
            return Response.of(Long.valueOf(hitRecord.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockHitRecord(Integer id){
        try{
            final HitRecord hitRecord = this.hitRecordRepositoryWrapper.findOneWithNotFoundDetection(id);
            hitRecord.setValid(false);
            this.hitRecordRepository.saveAndFlush(hitRecord);
            return Response.of(id);
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockHitRecord(Integer id){
        try{
            final HitRecord hitRecord = this.hitRecordRepositoryWrapper.findOneWithNotFoundDetection(id);
            hitRecord.setValid(true);
            hitRecord.setStatus(Status.ACTIVE);
            hitRecord.setUpdatedAt(LocalDateTime.now());
            this.hitRecordRepository.saveAndFlush(hitRecord);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
