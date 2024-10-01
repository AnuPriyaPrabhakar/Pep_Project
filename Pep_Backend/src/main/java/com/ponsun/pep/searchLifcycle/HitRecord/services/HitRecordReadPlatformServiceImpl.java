package com.ponsun.pep.searchLifcycle.HitRecord.services;

import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordData;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecord;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecordRepository;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecordRepositoryWrapper;
import com.ponsun.pep.searchLifcycle.HitRecord.rowmapper.HitRecordRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HitRecordReadPlatformServiceImpl implements HitRecordReadPlatformService{
    private final HitRecordRepositoryWrapper hitRecordRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final HitRecordRepository hitRecordRepository;
    private final HitRecordRowMapper hitRecordRowMapper;

    @Override
    public HitRecord fetchAlHitRecordById(Integer id){return this.hitRecordRepository.findById(id).get();}

    @Override
    public List<HitRecordData> fetchAllHitRecordById(Integer searchId){
        final HitRecordRowMapper rowMapper = new HitRecordRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE searchId=? ";
        Qry = Qry + whereClause;
        final List<HitRecordData> hitRecordDataList = jdbcTemplate.query(Qry,new Object[]{searchId},hitRecordRowMapper);
        return hitRecordDataList;
    }

    @Override
    public List<HitRecordData> fetchAllSearchById(Integer searchId) {
        final HitRecordRowMapper rowMapper = new HitRecordRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE searchId=? ";
        Qry = Qry + whereClause;

        final List<HitRecordData> hitRecordDataList = jdbcTemplate.query(Qry, new Object[]{searchId}, hitRecordRowMapper);
        return hitRecordDataList;
    }
    @Override
    public List<HitRecord> fetchAll(){return this.hitRecordRepository.findAll();}
}
