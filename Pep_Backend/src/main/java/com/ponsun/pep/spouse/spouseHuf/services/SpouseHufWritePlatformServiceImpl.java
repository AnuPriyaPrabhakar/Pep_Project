package com.ponsun.pep.spouse.spouseHuf.services;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseHufDTO;
import com.ponsun.pep.spouse.spouseHuf.data.SpouseHufDataValidator;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHuf;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHufRepository;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHufRepositoryWrapper;
import com.ponsun.pep.spouse.spouseHuf.request.CreateSpouseHufRequest;
import com.ponsun.pep.spouse.spouseHuf.request.UpdateSpouseHufRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.spouseHuf.rowmapper.SpouseHufRowMapper;
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
public class SpouseHufWritePlatformServiceImpl implements SpouseHufWritePlatformService {

    private final SpouseHufRepository spouseHufRepository;
    private final SpouseHufRepositoryWrapper spouseHufRepositoryWrapper;
    private final SpouseHufDataValidator spouseHufDataValidator;
    private final SpouseHufRowMapper spouseHufRowMapper;
    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public Response createSpouseHuf(CreateSpouseHufRequest createSpouseHufRequest) {
        try {
            this.spouseHufDataValidator.validateSaveSpouseHuf(createSpouseHufRequest);
            final SpouseHuf spouseHuf = SpouseHuf.create(createSpouseHufRequest);
            this.spouseHufRepository.saveAndFlush(spouseHuf);
            return Response.of(Long.valueOf(spouseHuf.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateSpouseHuf(Integer id, UpdateSpouseHufRequest updateSpouseHufRequest) {
        try {
            this.spouseHufDataValidator.validateUpdateSpouseHuf(updateSpouseHufRequest);
            final SpouseHuf spouseHuf = this.spouseHufRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseHuf.update(updateSpouseHufRequest);
            this.spouseHufRepository.saveAndFlush(spouseHuf);
            return Response.of(Long.valueOf(spouseHuf.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
 @Override
 @Transactional
 public  Response blockSpouseHuf(Integer id){
        try {
            final SpouseHuf spouseHuf = this.spouseHufRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseHuf.setStatus(Status.DELETE);
            spouseHuf.setUpdatedAt(LocalDateTime.now());
            this.spouseHufRepository.saveAndFlush(spouseHuf);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
 }
@Override
    @Transactional
    public Response unblockSpouseHuf(Integer id){
        try {
            final SpouseHuf spouseHuf = this.spouseHufRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseHuf.setStatus(Status.ACTIVE);
            spouseHuf.setUpdatedAt(LocalDateTime.now());
            this.spouseHufRepository.saveAndFlush(spouseHuf);
            return Response.of(Long.valueOf(id));
        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<SpouseHufDTO> fetchSpouseHufDTO(Integer pepId, Integer spouseId) {
        final SpouseHufRowMapper rowMapper = new SpouseHufRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE sh.pepId = ? and sh.spouseId=? AND sh.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<SpouseHufDTO> spouseHufDTOList  = jdbcTemplate.query(Qry,spouseHufRowMapper,
                new Object[] {pepId,spouseId}
        );
        return spouseHufDTOList;
    }
}
