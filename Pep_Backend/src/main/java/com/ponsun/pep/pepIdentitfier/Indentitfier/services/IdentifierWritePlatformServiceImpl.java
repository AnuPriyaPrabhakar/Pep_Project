package com.ponsun.pep.pepIdentitfier.Indentitfier.services;

import com.ponsun.pep.pepIdentitfier.Indentitfier.data.IdentifierData;
import com.ponsun.pep.pepIdentitfier.Indentitfier.rowmapper.IdentifierRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IdentifierWritePlatformServiceImpl implements  IdentifierWritePlatformService {

    private final JdbcTemplate jdbcTemplate;
    private final IdentifierRowMapper identifierRowMapper;
    @Override
    public List<IdentifierData> fetchAllIdentifierData(String name) {

        final IdentifierRowMapper rowMapper = new IdentifierRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.pepId=b.id AND a.NAME LIKE '%"+name+"%' ";
        Qry = Qry + whereClause;
        final List<IdentifierData> identifierDataList  = jdbcTemplate.query(Qry,identifierRowMapper,
                new Object[] {}
        );

        return identifierDataList;
    }

}
