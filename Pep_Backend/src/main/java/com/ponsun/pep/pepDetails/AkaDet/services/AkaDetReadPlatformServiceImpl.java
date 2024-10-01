package com.ponsun.pep.pepDetails.AkaDet.services;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDet;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDetRepository;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDetRepositoryWrapper;
import com.ponsun.pep.pepDetails.AkaDet.rowmapper.AkaDetRowmapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AkaDetReadPlatformServiceImpl implements AkaDetReadPlatformService{
    private final AkaDetRepositoryWrapper akaDetRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AkaDetRepository akaDetRepository;
    @Override
    public AkaDet fetchAkaDetById(Integer id){
        return this.akaDetRepository.findById(id).get();
    }

    @Override
    public List<AkaDetData> findBycustomePepId(Integer pepId){
        final AkaDetRowmapper rowmapper = new AkaDetRowmapper();
        String qry = " SELECT " +rowmapper.tableSchema() ;
        qry = qry + " WHERE pad.pepId= "+pepId +" and status = 'A'";
        final List<AkaDetData> akaDetData = jdbcTemplate.query(qry, rowmapper);
        return akaDetData;
    }
    @Override
    public List<AkaDet> fetchAllAkaDet(){
        return this.akaDetRepository.findAll();
    }
}
