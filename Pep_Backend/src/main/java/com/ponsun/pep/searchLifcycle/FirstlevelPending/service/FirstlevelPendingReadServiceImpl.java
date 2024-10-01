package com.ponsun.pep.searchLifcycle.FirstlevelPending.service;


import com.ponsun.pep.searchLifcycle.FirstlevelPending.data.FirstlevelPendingData;
import com.ponsun.pep.searchLifcycle.FirstlevelPending.rowmapper.FirstlevelPendingRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FirstlevelPendingReadServiceImpl implements FirstlevelPendingReadService {
    private final JdbcTemplate jdbcTemplate;
    private final FirstlevelPendingRowMapper firstlevelPendingRowMapper;


    @Override
    public List<FirstlevelPendingData> fetchAllPendingData(Integer id) {
        final FirstlevelPendingRowMapper rowMapper = new FirstlevelPendingRowMapper();
        String Qry = rowMapper.tableSchema();
        final List<FirstlevelPendingData> firstlevelPendingData = jdbcTemplate.query(Qry, new Object[]{id}, firstlevelPendingRowMapper);
        return firstlevelPendingData;
    }

}
