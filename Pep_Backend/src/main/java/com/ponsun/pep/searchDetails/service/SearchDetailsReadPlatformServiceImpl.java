
//package com.ponsun.pep.searchDetails.service;
//
//import com.ponsun.pep.searchDetails.rowmapper.SearchDetailsRowMapper;
//import com.ponsun.pep.searchDetails.data.SearchDetailsData;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class SearchDetailsReadServiceImpl implements SearchDetailsReadService {
//    private final JdbcTemplate jdbcTemplate;
//    private final SearchDetailsRowMapper searchDetailsRowMapper;
//
//    @Override
//    public List<SearchDetailsData> fetchAllDetailsDataById(Integer searchId) {
//
//        final SearchDetailsRowMapper rowMapper = new SearchDetailsRowMapper();
//        String Qry = "SELECT "  + rowMapper.tableSchema();
//        String whereClause = " WHERE searchId=? ";
//        Qry = Qry + whereClause;
//        final List<SearchDetailsData> searchDetailsDataList=  jdbcTemplate.query(Qry, new Object[]{searchId}, searchDetailsRowMapper);
//        return searchDetailsDataList;
//    }
//
//}
//
package com.ponsun.pep.searchDetails.service;

import com.ponsun.pep.searchDetails.data.SearchDetailsData;
import com.ponsun.pep.searchDetails.domain.SearchDetails;
import com.ponsun.pep.searchDetails.domain.SearchDetailsRepository;
import com.ponsun.pep.searchDetails.rowmapper.SearchDetailsRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchDetailsReadPlatformServiceImpl implements SearchDetailsReadPlatformService{
    private final SearchDetailsRepository searchDetailsRepository;
    private final JdbcTemplate jdbcTemplate;
    private final SearchDetailsRowMapper searchDetailsRowMapper;

    @Override
    public List<SearchDetailsData> fetchAllDetailsDataById(Integer searchId){
        final SearchDetailsRowMapper rowMapper = new SearchDetailsRowMapper();
        String Qry = "SELECT " +rowMapper.tableSchema();
        String whereClause = " WHERE searchId=? ";
        Qry = Qry + whereClause;
        final List<SearchDetailsData> searchDetailsDataList = jdbcTemplate.query(Qry,new Object[]{searchId},searchDetailsRowMapper);
        return searchDetailsDataList;
    }

    @Override
    public SearchDetails fetchSearchDetailsById(Integer id){return this.searchDetailsRepository.findById(id).get();}
    @Override
    public List<SearchDetails> fetchAllSearchDetails(){return this.searchDetailsRepository.findAll();}
}
