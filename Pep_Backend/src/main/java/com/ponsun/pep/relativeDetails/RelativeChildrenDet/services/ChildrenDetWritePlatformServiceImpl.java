package com.ponsun.pep.relativeDetails.RelativeChildrenDet.services;

import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepository;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepositoryWrapper;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.UpdateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.rowmapper.ChildrenDetRowMapper;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChildrenDetWritePlatformServiceImpl implements ChildrenDetWritePlatformService {

    private final ChildrenDetRepository childrenDetRepository;
    private final ChildrenDetRepositoryWrapper childrenDetRepositoryWrapper;
    private final ChildrenDetRowMapper childrenDetRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional

    public Response createChildrenDet(CreateChildrenDetRequest createChildrenDetRequest) {
        try {
            final ChildrenDet childrenDet = ChildrenDet.create(createChildrenDetRequest);//entity
            this.childrenDetRepository.saveAndFlush(childrenDet);
            return Response.of(Long.valueOf(childrenDet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateChildrenDet(Integer id, UpdateChildrenDetRequest updateChildrenDetRequest) {
        try {
            ChildrenDet childrenDet = this.childrenDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            childrenDet.setPepId(updateChildrenDetRequest.getPepId());
            childrenDet.setRelativeDetId(updateChildrenDetRequest.getRelativeDetId());
            childrenDet.setChildrenName(updateChildrenDetRequest.getChildrenName());
            childrenDet.setPan(updateChildrenDetRequest.getPan());
            childrenDet.setStatus(Status.ACTIVE);
            childrenDet.setUpdatedAt(LocalDateTime.now());
            return Response.of(Long.valueOf(childrenDet.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deactive(Integer pepId, Integer euid){
        try{
            List<ChildrenDet> childrenDets = this.childrenDetRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
            Response response = null;
            for (ChildrenDet childrenDet : childrenDets) {
                childrenDet.setEuid(euid);
                childrenDet.setStatus(Status.ACTIVE);
                childrenDet.setUpdatedAt(LocalDateTime.now());
                response = Response.of(childrenDet.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deleteChildrenDet(Integer id) {
        try {
            Optional<ChildrenDet> optionalChildrenDet= childrenDetRepository.findById(id);
            if (optionalChildrenDet.isPresent()) {
                childrenDetRepository.delete(optionalChildrenDet.get());
                return Response.of(Long.valueOf(id));
            } else {
                throw new EntityNotFoundException("ChildrenDet not found with ID: " + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

@Override
public List<RelativeChildrenDTO> fetchRelativeChildrenDTO(Integer pepId,Integer relativeId) {

    final ChildrenDetRowMapper rowMapper = new ChildrenDetRowMapper();
    String Qry = "SELECT "  + rowMapper.tableSchema();
    String whereClause = " WHERE rdc.pepId = ? and rdc.relativeId=? AND rdc.STATUS = 'A'";
    Qry = Qry + whereClause;
    final List<RelativeChildrenDTO> relativeChildrenDTOList  = jdbcTemplate.query(Qry,childrenDetRowMapper,
            new Object[] {pepId,relativeId}
    );

    return relativeChildrenDTOList;
}
}



