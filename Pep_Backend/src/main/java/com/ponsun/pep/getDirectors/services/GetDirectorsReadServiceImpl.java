package com.ponsun.pep.getDirectors.services;

import com.ponsun.pep.getDirectors.data.GetDirectorsData;
import com.ponsun.pep.getDirectors.rowmapper.GetDirectorsRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetDirectorsReadServiceImpl implements GetDirectorsReadService {

    private final JdbcTemplate jdbcTemplate;
    private final GetDirectorsRowMapper getDirectorsRowMapper;

    @Override
    public List<GetDirectorsData> fetchGetDirectorsData(String pan) {
        final GetDirectorsRowMapper rowMapper = new GetDirectorsRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE b.pan = ? AND a.din = b.directorsIdentificationNumber";
        Qry = Qry + whereClause;
        final List<GetDirectorsData> GetDirectorsData = jdbcTemplate.query(Qry, getDirectorsRowMapper,
                new Object[]{pan}
        );
        return GetDirectorsData;
    }
}
