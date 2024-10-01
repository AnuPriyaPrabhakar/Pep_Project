package com.ponsun.pep.bulkTaskAssignView.service;


import com.ponsun.pep.bulkTaskAssignView.data.BulkTaskAssignViewData;
import com.ponsun.pep.bulkTaskAssignView.rowmapper.BulkTaskAssignViewRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BulkTaskAssignViewReadServiceImpl implements BulkTaskAssignViewReadService {

    private final BulkTaskAssignViewRowMapper bulkTaskAssignViewRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<BulkTaskAssignViewData> fetchAllBulkTaskAssignView(Integer uid) {
        final BulkTaskAssignViewRowMapper rowMapper = new BulkTaskAssignViewRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE b.id = ? ";
        Qry = Qry + whereClause;
        final List<BulkTaskAssignViewData> bulkTaskAssignViewData = jdbcTemplate.query(Qry, new Object[]{uid}, bulkTaskAssignViewRowMapper);
        return bulkTaskAssignViewData;
    }
}