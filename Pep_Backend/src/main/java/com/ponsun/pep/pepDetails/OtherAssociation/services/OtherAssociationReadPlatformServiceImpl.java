//package com.ponsun.pep.pepDetails.OtherAssociation.services;
//
//import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
//import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociation;
//import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociationRepository;
//import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociationRepositoryWrapper;
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
//public class OtherAssociationReadPlatformServiceImpl implements OtherAssociationReadPlatformService{
//    private final OtherAssociationRepositoryWrapper otherAssociationRepositoryWrapper;
//    private final JdbcTemplate jdbcTemplate;
//    private final OtherAssociationRepository otherAssociationRepository;
//    @Override
//    public OtherAssociation fetchOtherAssociationById(Integer id){
//        return this.otherAssociationRepository.findById(id).get();
//    }
//    @Override
//    public List<OtherAssociation> fetchAllOtherAssociation(){ return this.otherAssociationRepository.findAll();}
//
//    @Override
//    public List<OtherAssociationData> OtherAssociationFindByPepId(Integer pepId)
//    {
//        String status= "A";
//        return this.otherAssociationRepository.findByPepIdAndStatus(pepId,status);
//    }
//
//}
package com.ponsun.pep.pepDetails.OtherAssociation.services;

import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociation;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociationRepository;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociationRepositoryWrapper;
import com.ponsun.pep.pepDetails.OtherAssociation.rowmapper.OtherAssociationRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtherAssociationReadPlatformServiceImpl implements OtherAssociationReadPlatformService {
    private final OtherAssociationRepositoryWrapper otherAssociationRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final OtherAssociationRepository otherAssociationRepository;

    @Override
    public OtherAssociation fetchOtherAssociationById(Integer id) {
        return this.otherAssociationRepository.findById(id).get();
    }

    @Override
    public List<OtherAssociationData> OtherAssociationFindByPepId(Integer pepId) {
        final OtherAssociationRowMapper rowmapper = new OtherAssociationRowMapper();
        String qry = "SELECT " + rowmapper.tableSchema();
        qry = qry + " WHERE oa.pepId = " + pepId + " AND status = 'A'";
        final List<OtherAssociationData> otherAssociationData = jdbcTemplate.query(qry, rowmapper);
        return otherAssociationData;
    }

    @Override
    public List<OtherAssociation> fetchAllOtherAssociation() {
        return this.otherAssociationRepository.findAll();
    }
}
