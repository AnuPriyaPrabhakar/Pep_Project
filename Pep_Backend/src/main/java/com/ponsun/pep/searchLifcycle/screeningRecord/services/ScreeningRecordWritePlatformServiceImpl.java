package com.ponsun.pep.searchLifcycle.screeningRecord.services;

import com.ponsun.pep.searchLifcycle.screeningRecord.data.ScreeningRecordData;
import com.ponsun.pep.searchLifcycle.screeningRecord.rowMapper.ScreeningRecordRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScreeningRecordWritePlatformServiceImpl implements ScreeningRecordWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final ScreeningRecordRowMapper screeningRecordRowMapper;

    @Override
    public List<ScreeningRecordData> fetchAllScreeningRecord(Integer id){
       Map<String,Object> parameters = new HashMap<>();
       parameters.put("id",id);

       final ScreeningRecordRowMapper rowMapper = new ScreeningRecordRowMapper();
       String Qry = "SELECT "+rowMapper.tableSchema();
       String whereClause = " WHERE a.id=b.`searchId` AND b.`criminalId`=c.`id` AND a.id=? ";
       Qry = Qry+whereClause;
       final List<ScreeningRecordData> screeningRecordData = jdbcTemplate.query(Qry,screeningRecordRowMapper,id);
       return screeningRecordData;
    }
}
