package com.ponsun.pep.EhcachePOC.Service;

import com.ponsun.pep.EhcachePOC.Data.OFACData;
import com.ponsun.pep.EhcachePOC.RowMapper.OFACRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@CacheConfig(cacheNames = "allOfacData")
@Service
public class OFACSearchServiceImpl implements OFACSearchService{
    private final JdbcTemplate jdbcTemplate;

    @Cacheable(value = "allOfacData")
    @Override
    public List<OFACData> fetchAllOFACData() {
        System.out.println("Data retrieved from database");
        final OFACRowMapper rowMapper = new OFACRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        final List<OFACData> ofacData = jdbcTemplate.query(Qry,rowMapper);
        return ofacData;
    }
    @Caching(evict = {
            @CacheEvict(value = "allOfacData", allEntries = true)
    })
    @Override
    public String deleteOfacData() {
        System.out.println("OfacData deleted in Caching");
        return "Successfully Data removed from Cache";
    }

}
