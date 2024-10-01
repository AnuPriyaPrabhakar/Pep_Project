package com.ponsun.pep.searchLifcycle.ScreeningSearch.services;

import com.ponsun.pep.searchLifcycle.ScreeningSearch.data.ScreeningSearchData;
import com.ponsun.pep.searchLifcycle.ScreeningSearch.rowmapper.ScreeningSearchRowMapper;
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
public class ScreeningSearchWritePlatformServiceImpl implements ScreeningSearchWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final ScreeningSearchRowMapper screeningSearchRowMapper;

    @Override
    public List<ScreeningSearchData> fetchAllScreeningSearch(Integer kycId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("kycId", kycId);

        final ScreeningSearchRowMapper rowMapper = new ScreeningSearchRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE kycId = ?";
        Qry = Qry + whereClause;
        final List<ScreeningSearchData> screenSearch = jdbcTemplate.query(Qry, screeningSearchRowMapper, kycId);

        return screenSearch;
    }


}
