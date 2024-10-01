package com.ponsun.pep.entityScreening.services;

import com.ponsun.pep.entityScreening.data.EntityScreeningData;
import com.ponsun.pep.entityScreening.rowmapper.EntityScreeningRowMapper;
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
public class EntityScreeningWritePlatformServiceImpl implements EntityScreeningWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final EntityScreeningRowMapper entityScreeningRowMapper;

//    @Override
//    public List<EntityScreeningData> fetchAllEntityScreening(Integer kycId){
//        Map<String,Object> parameters = new HashMap<>();
//        parameters.put("kycId", kycId);
//        final EntityScreeningRowMapper rowMapper = new EntityScreeningRowMapper();
//        String Qry = "SELECT " + rowMapper.tableSchema();
//        String whereClause = " WHERE searchId = (SELECT id FROM `pep_search` WHERE kycId = ?) ";
//        Qry = Qry + whereClause;
//
//        final List<EntityScreeningData> screeningData = jdbcTemplate.query(Qry,entityScreeningRowMapper,new Object[]{kycId});
//        return screeningData;
//    }

    @Override
    public List<EntityScreeningData> fetchAllEntityScreening(Integer kycId) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("kycId", kycId);

        final EntityScreeningRowMapper rowMapper = new EntityScreeningRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE searchId IN (SELECT id FROM pep_search WHERE kycId = ?) ";
        Qry = Qry + whereClause;

        log.info("Executing query: {}", Qry);

        try {
            return jdbcTemplate.query(Qry, entityScreeningRowMapper, kycId);
        } catch (Exception e) {
            log.error("Error executing query: {}, Error: {}", Qry, e.getMessage());
            throw e;
        }
    }

}
