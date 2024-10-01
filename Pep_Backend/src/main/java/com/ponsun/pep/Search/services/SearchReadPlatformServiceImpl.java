package com.ponsun.pep.Search.services;

import com.ponsun.pep.ReportRecord.data.ReportRecordDtos;
import com.ponsun.pep.Search.data.RecordDTO;
import com.ponsun.pep.Search.data.SearchDTO;
import com.ponsun.pep.Search.data.SearchData;
import com.ponsun.pep.Search.data.SearchDtos;
import com.ponsun.pep.Search.domain.Search;
import com.ponsun.pep.Search.domain.SearchRepository;
import com.ponsun.pep.Search.rowmapper.SearchRowMapper;
import com.ponsun.pep.algorithm.ScoringCalculator;
import com.ponsun.pep.customerDetails.data.CustomerDetailsData;
import com.ponsun.pep.customerDetails.rowmaper.CustomerDetailsRowMapper;
import com.ponsun.pep.customerDetails.services.CustomerDetailsWritePlatformService;
import com.ponsun.pep.searchDetails.data.SearchDetailsData;
import com.ponsun.pep.searchDetails.rowmapper.SearchDetailsRowMapper;
import com.ponsun.pep.searchDetails.service.SearchDetailsReadPlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Slf4j
@RequiredArgsConstructor
public class SearchReadPlatformServiceImpl implements SearchReadPlatformService {

    private final SearchRepository searchRepository;
    private final JdbcTemplate jdbcTemplate;
    private final SearchRowMapper searchRowMapper;
    private final SearchDetailsRowMapper searchDetailsRowMapper;
    private final SearchDetailsReadPlatformService searchDetailsReadService;
    private final CustomerDetailsRowMapper customerDetailsRowMapper;
    private final ScoringCalculator scoringCalculator;
    final private CustomerDetailsWritePlatformService customerDetailsWritePlatformService;

    @Override
    public List<Search> fetchAllSearch() {
        return this.searchRepository.findAll();

    }

    @Override
    public List<SearchData> fetchAllSearch(String fromDate, String toDate){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate",fromDate);
        parameters.put("toDate",toDate);

        final SearchRowMapper rowMapper = new SearchRowMapper();
        String Qry ="SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(ps.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;

        final List<SearchData> searchData =  jdbcTemplate.query(Qry, searchRowMapper, new Object[]{fromDate,toDate});
        return searchData;
    }

    @Override
    public List<SearchDetailsData> fetchAllSearchDetails(String fromDate, String toDate){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate",fromDate);
        parameters.put("toDate",toDate);
        final SearchDetailsRowMapper rowMapper = new SearchDetailsRowMapper();
        String Qry ="SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(sd.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;
        final List<SearchDetailsData> searchDetailsData = jdbcTemplate.query(Qry,searchDetailsRowMapper,new Object[]{fromDate,toDate});
        return searchDetailsData;
    }

    @Override
//    @Transactional
//    @Transactional(rollbackFor = DataAccessException.class)
    public List<RecordDTO> getpepRecords(SearchDTO searchDto) {
        try {
//            final CustomerDetailsRowMapper rowMapper = new CustomerDetailsRowMapper();
//            List<CustomerDetailsData> combinedDTOList = new ArrayList<>();
//            int limitSize= 0;

//            String name             = searchDto.getName();
//            Double matching_score   = searchDto.getMatching_score();

            final List<CustomerDetailsData> customerDetailsData= this.customerDetailsWritePlatformService.fetchAllCustomerDetailsData();

            //System.out.println("customerDetailsData : "+customerDetailsData);

            List<RecordDTO> recordDTOList= this.scoringCalculator.calculateScore(searchDto, customerDetailsData);
            //System.out.println("recordDTOList : "+recordDTOList);
            return recordDTOList;
        } catch (DataAccessException e) {
            System.err.println("Error getTotalRecordsCount: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<ReportRecordDtos> fetchAllDetailData(String fromDate, String toDate) {
        SearchDtos searchDtosList = new SearchDtos();
        List<ReportRecordDtos> recordDtosList = new ArrayList<>();
        List<SearchData> searchDataList = fetchAllSearch(fromDate, toDate);
        ModelMapper modelMapper = new ModelMapper();

        for (SearchData searchData : searchDataList) {
            SearchDtos search = new SearchDtos();
            search.setId(searchData.getId());
            search.setName(searchData.getName());
            search.setSearchingScore(searchData.getSearchingScore());
            search.setUid(searchData.getUid());
            search.setEuid(searchData.getEuid());
            search.setFromDate(searchData.getFromDate());
            search.setToDate(searchData.getToDate());

            List<SearchDetailsData> searchDetailsData= this.searchDetailsReadService.fetchAllDetailsDataById(searchData.getId());
            search.setSearchDetailsData(searchDetailsData);

            recordDtosList.add(ReportRecordDtos.newInstance(search));
        }
        return recordDtosList;
    }
}
