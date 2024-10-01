package com.ponsun.pep.Edit.ManagerView.Services;

import com.ponsun.pep.Edit.ManagerView.data.ManagerViewData;
import com.ponsun.pep.Edit.ManagerView.rowmapper.ManagerViewRowMapper;
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
public class ManagerViewReadPlatformServiceImpl implements ManagerViewReadPlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final ManagerViewRowMapper managerViewRowMapper;

    @Override
    public List<ManagerViewData> fetchAllManagerViewData(String fromDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate",fromDate);
        parameters.put("toDate",toDate);

        final ManagerViewRowMapper rowMapper = new ManagerViewRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.pepId=b.id AND a.status='A' AND manager_view=1 AND manager_approve=0 ";
        Qry = Qry + whereClause;
        final List<ManagerViewData> managerViewData = jdbcTemplate.query(Qry, managerViewRowMapper,
                new Object[]{}
        );
        return managerViewData;
    }
}