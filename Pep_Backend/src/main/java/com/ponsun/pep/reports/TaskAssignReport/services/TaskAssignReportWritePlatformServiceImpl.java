package com.ponsun.pep.reports.TaskAssignReport.services;

import com.ponsun.pep.reports.TaskAssignReport.data.TaskAssignReportData;
import com.ponsun.pep.reports.TaskAssignReport.rowmapper.TaskAssignReportRowMapper;
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
public class TaskAssignReportWritePlatformServiceImpl implements TaskAssignReportWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final TaskAssignReportRowMapper taskAssignReportRowMapper;
    @Override
    public List<TaskAssignReportData> fetchAllTaskAssignReportData(String frmDate,String toDate){
        Map<String ,Object> parameters = new HashMap<>();

        parameters.put("frmDate",frmDate);
        parameters.put("toDate" ,toDate);
        final TaskAssignReportRowMapper rowMapper = new TaskAssignReportRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.assignTo=b.id AND c.id=a.stateId AND d.id=a.countryId AND DATE(a.created_at) BETWEEN ? AND ?  ";
        Qry = Qry + whereClause;
        final List<TaskAssignReportData> taskAssignReportData = jdbcTemplate.query(Qry,taskAssignReportRowMapper,new Object[] {frmDate,toDate});
    return taskAssignReportData;}
}
