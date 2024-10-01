package com.ponsun.pep.searchLifcycle.RemarkDetails.services;

import com.ponsun.pep.searchLifcycle.RemarkDetails.data.RemarkDetailsData;
import com.ponsun.pep.searchLifcycle.RemarkDetails.rowmapper.RemarkDetailsRowmapper;
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
public class RemarkDetailsReadPlatformServiceImpl implements RemarkDetailsReadPlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final RemarkDetailsRowmapper remarkDetailsRowmapper;

    @Override
    public List<RemarkDetailsData> fetchAllRemark(Integer hitdataId){
        Map<String,Object> parameters = new HashMap<>();
        final RemarkDetailsRowmapper rowmapper = new RemarkDetailsRowmapper();
        String Qry = "SELECT "+ rowmapper.tableSchema();
        String whereClause=" WHERE hitdata_id=? ";
        Qry = Qry + whereClause;
        final List<RemarkDetailsData> remarkDetailsData = jdbcTemplate.query(Qry,new Object[]{hitdataId},remarkDetailsRowmapper);
        return remarkDetailsData;
    }
}
