package com.ponsun.pep.relativeDetails.Relative.services;

import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.relativeDetails.Relative.rowmapper.RelativeRowmapper;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepositoryWrapper;
import com.ponsun.pep.relativeDetails.Relativedet.services.RelativeDetWritePlatformService;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relative.data.RelativeDataValidator;
import com.ponsun.pep.relativeDetails.Relative.domain.Relative;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepository;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepositoryWrapper;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.request.UpdateRelativeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeWritePlatformServiceImpl implements RelativeWritePlatformService {

    private final RelativeRepository relativeRepository;
    private final RelativeRepositoryWrapper relativeRepositoryWrapper;
    private final RelativeDataValidator relativeDataValidator;
    private final RelativeDetRepositoryWrapper relativeDetRepositoryWrapper;
    private final RelativeRowmapper relativeRowmapper;
    private final JdbcTemplate jdbcTemplate;

    private final RelativeDetWritePlatformService relativeDetWritePlatformService;



    @Override
    @Transactional
    public Response createRelative(CreateRelativeRequest createRelativeRequest) {
        try {
            this.relativeDataValidator.validateSaveRelative(createRelativeRequest);
            final Relative relative = Relative.create(createRelativeRequest);//entity
            this.relativeRepository.save(relative);
            return Response.of(Long.valueOf(relative.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
        public Response updateRelative(Integer id, UpdateRelativeRequest updateRelativeRequest) {
           try {
               this.relativeDataValidator.validateUpdateRelative(updateRelativeRequest);
               final Relative relative = this.relativeRepositoryWrapper.findOneWithNotFoundDetection(id);
               relative.update(updateRelativeRequest);
               this.relativeRepository.saveAndFlush(relative);
               return Response.of(Long.valueOf(relative.getId()));

           }catch (DataIntegrityViolationException e){
               throw new EQAS_PEP_AppicationException(e.getMessage());
           }
        }
    @Override
    @Transactional
    public Response blockRelative(Integer id){
        try {
            final Relative relative = this.relativeRepositoryWrapper.findOneWithNotFoundDetection(id);
            relative.setStatus(Status.DELETE); // Or set the appropriate status
            relative.setUpdatedAt(LocalDateTime.now());
            this.relativeRepository.saveAndFlush(relative);
            return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response DeactiveRelative(Integer pepId, Integer euid){
        try {

            Response response = null;
            updateEntity(pepId,euid);
            updateRelativeDetEntity(pepId ,euid);
            updateChildrenEntity(pepId,euid);
            return response;

        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

//    public void updateEntity(Integer pepId,Integer relativeMasterId,Integer euid) {
//        String sql = "UPDATE pep_relative  SET STATUS='D',euid= ?,updated_at=now() WHERE pepId= ? AND relativeMasterId= ?";
//        jdbcTemplate.update(sql, euid, pepId, relativeMasterId);
//    }
//
//    private Integer getRelativeId(Integer pepId) {
//        String selectQuery = "SELECT id FROM pep_relative WHERE pepId=? LIMIT 1";
//        return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, pepId);
//    }
//
//    public void updateRelativeDetEntity(Integer pepId, Integer euid) {
//        Integer relativeId = getRelativeId(pepId);
//        String updateQuery = "UPDATE pep_relative_det SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=? AND relativeId=?";
//        this.jdbcTemplate.update(updateQuery, euid, pepId, relativeId);
//    }
//
//    public void updateChildrenEntity(Integer pepId, Integer euid) {
//        Integer relativeId = getRelativeId(pepId);
//        String str = "UPDATE pep_relative_det_children SET STATUS='D', euid=?, updated_at=now() WHERE pepId=? AND relativeId=?";
//        this.jdbcTemplate.update(str, euid, pepId, relativeId);
//    }

    public void updateEntity(Integer pepId,Integer euid) {
        //String sql = "UPDATE pep_relative  SET STATUS='D',euid= ?,updated_at=now() WHERE pepId= ? AND relativeMasterId= ?";
        String sql = "UPDATE pep_relative  SET STATUS='D',euid= ?,updated_at=now() WHERE pepId= ?";
        jdbcTemplate.update(sql, euid, pepId);
    }

    private Integer getRelativeId(Integer pepId) {
        String selectQuery = "SELECT id FROM pep_relative WHERE pepId=? LIMIT 1";
        return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, pepId);
    }

    public void updateRelativeDetEntity(Integer pepId, Integer euid) {
        //Integer relativeId = getRelativeId(pepId);
        //String updateQuery = "UPDATE pep_relative_det SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=? AND relativeId=?";
        String updateQuery = "UPDATE pep_relative_det SET STATUS='D', euid=?, updated_at=NOW() WHERE pepId=?";
        this.jdbcTemplate.update(updateQuery, euid, pepId);
    }

    public void updateChildrenEntity(Integer pepId, Integer euid) {
        //Integer relativeId = getRelativeId(pepId);
        //String str = "UPDATE pep_relative_det_children SET STATUS='D', euid=?, updated_at=now() WHERE pepId=? AND relativeId=?";
        String str = "UPDATE pep_relative_det_children SET STATUS='D', euid=?, updated_at=now() WHERE pepId=?";
        this.jdbcTemplate.update(str, euid, pepId);
    }

    @Override
    @Transactional
    public Response unblockRelative(Integer id){
        try {
            final Relative Relative = this.relativeRepositoryWrapper.findOneWithNotFoundDetection(id);
            Relative.setStatus(Status.ACTIVE);
            Relative.setUpdatedAt(LocalDateTime.now());
            this.relativeRepository.saveAndFlush(Relative);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


        @Override
        @Transactional
        public List<RelativeData> fetchRelativeData(Integer pepId) {
            final RelativeRowmapper rowMapper = new RelativeRowmapper();
            String query = "SELECT " + rowMapper.tableSchema() +
                    " WHERE pr.pepId = ? AND pr.STATUS = 'A'";
            final List<RelativeData> relativeDataList = jdbcTemplate.query(
                    query,
                    new Object[] { pepId },
                    relativeRowmapper
            );
            return relativeDataList;
        }

}

