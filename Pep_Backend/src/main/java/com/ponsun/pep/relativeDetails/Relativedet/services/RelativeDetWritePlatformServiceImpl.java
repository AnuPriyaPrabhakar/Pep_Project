package com.ponsun.pep.relativeDetails.Relativedet.services;

import com.ponsun.pep.relativeDetails.Relativedet.rowmapper.RelativeDetRowmapper;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relativedet.data.RelativeDetDataValidator;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepository;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepositoryWrapper;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.request.UpdateRelativeDetRequest;
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
public class RelativeDetWritePlatformServiceImpl implements RelativeDetWritePlatformService {

    private final RelativeDetRepository relativeDetRepository;
    private final RelativeDetRepositoryWrapper relativeDetRepositoryWrapper;
    private final RelativeDetDataValidator relativeDetDataValidator;
    private final JdbcTemplate jdbcTemplate;
    private final RelativeDetRowmapper relativeDetRowmapper;

    @Override
    @Transactional
    public Response createRelativeDet(CreateRelativeDetRequest createRelativeDetRequest){
        try {
            this.relativeDetDataValidator.validateSaveRelativeDet(createRelativeDetRequest);
            final RelativeDet relativeDet = RelativeDet.create(createRelativeDetRequest);//entity
            this.relativeDetRepository.saveAndFlush(relativeDet);
            return Response.of(Long.valueOf(relativeDet.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());

        }
    }
    @Override
    @Transactional
    public Response updateRelativeDet(Integer id, UpdateRelativeDetRequest updateRelativeDetRequest){
        try {
            this.relativeDetDataValidator.validateUpdateRelativeDet(updateRelativeDetRequest);
            final RelativeDet relativeDet = this.relativeDetRepositoryWrapper.findWithNotFoundDetection(id);
            relativeDet.update(updateRelativeDetRequest);
            this.relativeDetRepository.saveAndFlush(relativeDet);
            return Response.of(Long.valueOf(relativeDet.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deactive(Integer pepId, Integer euid){
        try{
            List<RelativeDet> relativeDets = this.relativeDetRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
            Response response = null;
            for (RelativeDet relativeDet : relativeDets) {
                relativeDet.setEuid(euid);
                relativeDet.setStatus(Status.ACTIVE);
                relativeDet.setUpdatedAt(LocalDateTime.now());
                response = Response.of(relativeDet.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
@Override
@Transactional
    public Response blockRelativeDet(Integer id){
        try {
            final RelativeDet relativeDet = this.relativeDetRepositoryWrapper.findWithNotFoundDetection(id);
            relativeDet.setStatus(Status.DELETE); // Or set the appropriate status
            relativeDet.setUpdatedAt(LocalDateTime.now());
            this.relativeDetRepository.saveAndFlush(relativeDet);
            return Response.of(Long.valueOf(id));

            }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
}
    @Override
    @Transactional
    public Response unblockRelativeDet(Integer id){
        try {
            final RelativeDet relativeDet = this.relativeDetRepositoryWrapper.findWithNotFoundDetection(id);
            relativeDet.setStatus(Status.ACTIVE); // Or set the appropriate status
            relativeDet.setUpdatedAt(LocalDateTime.now());
            this.relativeDetRepository.saveAndFlush(relativeDet);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

//    @Override
//    public List<RelativeDetDTO> fetchRelativeDetDTO(Integer pepId) {
//
//        final RelativeDetRowmapper rowMapper = new RelativeDetRowmapper();
//        String Qry = "SELECT "  + rowMapper.tableSchema();
//        String whereClause = " WHERE prd.pepId = ? AND prd.STATUS = 'A'";
//        Qry = Qry + whereClause;
//        final List<RelativeDetDTO> relativeChildrenDTOList  = jdbcTemplate.query(Qry,relativeDetRowmapper,
//                new Object[] {pepId}
//        );
//
//        return relativeChildrenDTOList;
//    }
@Override
public List<RelativeDetDTO> fetchRelativeDetDTO(Integer pepId,Integer relativeId) {

    final RelativeDetRowmapper rowMapper = new RelativeDetRowmapper();
    String Qry = "SELECT "  + rowMapper.tableSchema();
    String whereClause = " WHERE prd.pepId = ? and prd.relativeId=? AND prd.STATUS = 'A'";
    Qry = Qry + whereClause;
    final List<RelativeDetDTO> relativeChildrenDTOList  = jdbcTemplate.query(Qry,relativeDetRowmapper,
            new Object[] {pepId,relativeId}
    );

    return relativeChildrenDTOList;
}

}
