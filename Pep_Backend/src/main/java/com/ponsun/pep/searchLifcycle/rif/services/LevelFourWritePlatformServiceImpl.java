package com.ponsun.pep.searchLifcycle.rif.services;

import com.ponsun.pep.searchLifcycle.rif.data.LevelFourData;
import com.ponsun.pep.searchLifcycle.rif.rowmapper.LevelFourRowmapper;
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
public class LevelFourWritePlatformServiceImpl  implements  LevelFourWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final LevelFourRowmapper levelFourRowmapper;

    @Override
    public List<LevelFourData> fetchAllLevelFourData(Integer levelId){
        Map<String,Object>parameters = new HashMap<>();
        final LevelFourRowmapper rowmapper = new LevelFourRowmapper();
        String Qry = "SELECT "+ rowmapper.tableSchema();
        String whereClause =" WHERE f.hitdata_id=b.id AND f.valid=1 AND f.statusId=3 AND a.id=b.searchId AND f.level_id= ?";
        Qry = Qry + whereClause;
        final List <LevelFourData> levelFourData = jdbcTemplate.query(Qry,new Object[]{levelId} ,levelFourRowmapper);
        return levelFourData;
    }
}
