package com.ponsun.pep.searchLifcycle.searchResult.services;

import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordData;
import com.ponsun.pep.searchLifcycle.HitRecord.domain.HitRecordRepository;
import com.ponsun.pep.searchLifcycle.HitRecord.rowmapper.HitRecordRowMapper;
import com.ponsun.pep.searchLifcycle.HitRecord.services.HitRecordReadPlatformService;
import com.ponsun.pep.searchLifcycle.searchResult.data.SearchResultData;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResult;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResultRepository;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResultRepositoryWrapperResult;
import com.ponsun.pep.searchLifcycle.searchResult.rowMapper.SearchResultRowMapper;
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
public class SearchResultReadPlatformServiceImpl implements SearchResultReadPlatformService {
    private final SearchResultRepositoryWrapperResult searchResultRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final SearchResultRepository searchResultRepository;
    private final SearchResultRowMapper searchResultRowMapper;
    private final HitRecordRowMapper hitRecordRowMapper;
    private final HitRecordRepository hitRecordRepository;
    private final HitRecordReadPlatformService hitRecordReadPlatformService;
    private final SearchResultWritePlatformService searchResultWritePlatformService;

    @Override
    public SearchResult fetchSearchById(Integer id) {
        return this.searchResultRepository.findById(id).get();
    }
    @Override
    public List<SearchResult> fetchAllSearch() {
        return this.searchResultRepository.findAll();
    }

    @Override
    public List<SearchResultData>fetchAllSearchDetailData(String fromDate, String toDate){

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate", fromDate);
        parameters.put("toDate", toDate);
        final SearchResultRowMapper rowMapper = new SearchResultRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(cs.created_at) BETWEEN ? AND ? ";
        Qry = Qry + whereClause;
        final List<SearchResultData> searchDetailData = jdbcTemplate.query(Qry, searchResultRowMapper,
                new Object[] {fromDate , toDate});
        return searchDetailData;
    }

    @Override
    public List<HitRecordData>fetchAllRecordData(String fromDate, String toDate){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("frmDate", fromDate);
        parameters.put("toDate", toDate);
        final HitRecordRowMapper rowMapper=new HitRecordRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(hit.created_at) BETWEEN ? AND ? ";
        Qry = Qry + whereClause;
        final List<HitRecordData> hitRecordDataList = jdbcTemplate.query(Qry,hitRecordRowMapper,
                new Object[] {fromDate , toDate}
        );
        return hitRecordDataList;
    }
}
