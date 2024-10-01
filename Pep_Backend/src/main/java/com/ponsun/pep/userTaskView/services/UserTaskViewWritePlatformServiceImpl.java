package com.ponsun.pep.userTaskView.services;

import com.ponsun.pep.userTaskView.rowmapper.UserTaskViewRowMapper;
import com.ponsun.pep.userTaskView.data.UserTaskViewData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserTaskViewWritePlatformServiceImpl implements UserTaskViewWritePlatformService {

    private final JdbcTemplate jdbcTemplate;
    private final UserTaskViewRowMapper FirstPageRowMapper;

    @Override
    public List<UserTaskViewData> fetchAllFirstPageData(Integer assignTo) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("assignTo", assignTo);

        final UserTaskViewRowMapper rowMapper = new UserTaskViewRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.countryId=b.id AND a.stateId=c.id AND a.assignTo =d.id AND a.assignTo= ? AND a.status='A' AND a.valid=1;";
        Qry = Qry + whereClause;

        final List<UserTaskViewData> FirstPageData = jdbcTemplate.query(Qry,FirstPageRowMapper,
                new Object[] {assignTo}
        );
        return FirstPageData;
    }
}

