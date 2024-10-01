package com.ponsun.pep.Edit.ManagerViewPending.services;


import com.ponsun.pep.Edit.ManagerViewPending.data.ManagerViewPendingData;
import com.ponsun.pep.Edit.ManagerViewPending.rowmapper.ManagerViewPendingRowMapper;
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
public class ManagerViewPendingReadPlatformServiceImpl implements ManagerViewPendingReadPlatformService {

    private final JdbcTemplate jdbcTemplate;
    private final ManagerViewPendingRowMapper managerViewPendingRowMapper;

    @Override
    public List<ManagerViewPendingData> fetchAllManagerViewPendingData(String fromDate, String toDate) {

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("fromDate",fromDate);
            parameters.put("toDate",toDate);


        final ManagerViewPendingRowMapper rowMapper = new ManagerViewPendingRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.pepId=b.id AND a.status='A' AND manager_view=0 AND manager_approve=0";
        Qry = Qry + whereClause;
        final List<ManagerViewPendingData> managerViewPendingData = jdbcTemplate.query(Qry, managerViewPendingRowMapper,
                new Object[] {}
        );
        return managerViewPendingData;
    }

}
