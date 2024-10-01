package com.ponsun.pep.roles.RolesCommonService.service;

import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleCommonReadPlatformServiceImpl implements  RoleCommonReadPlatformService{

    private final RoleRowMapper roleRowMapper;
    private  final JdbcTemplate jdbcTemplate;
    @Override
    public List<RoleData> fetchRoleData() {
        final RoleRowMapper rowMapper = new RoleRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE STATUS = 'A' ";
        Qry = Qry + whereClause;
        final List<RoleData> roleData = jdbcTemplate.query(Qry, new Object[] {}, roleRowMapper);
        return roleData;
    }

}
