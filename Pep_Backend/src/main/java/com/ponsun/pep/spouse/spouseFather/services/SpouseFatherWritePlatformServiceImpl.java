package com.ponsun.pep.spouse.spouseFather.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseFatherDTO;
import com.ponsun.pep.spouse.spouseFather.data.SpouseFatherDataValidator;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFather;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFatherRepository;
import com.ponsun.pep.spouse.spouseFather.request.CreateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.request.UpdateSpouseFatherRequest;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFatherRepositoryWrapper;
import com.ponsun.pep.spouse.spouseFather.rowmapper.SpouseFatherRowMapper;
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
public class SpouseFatherWritePlatformServiceImpl implements SpouseFatherWritePlatformService {

    private final SpouseFatherRepository spouseFatherRepository;
    private final SpouseFatherRepositoryWrapper spouseFatherRepositoryWrapper;
    private final SpouseFatherDataValidator spouseFatherDataValidator;
    private final SpouseFatherRowMapper spouseFatherRowMapper;
    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public Response createSpouseFather(CreateSpouseFatherRequest createSpouseFatherRequest) {
        try {
            this.spouseFatherDataValidator.validateSaveSpouseFather(createSpouseFatherRequest);
            final SpouseFather spouseFather = SpouseFather.create(createSpouseFatherRequest);
            this.spouseFatherRepository.saveAndFlush(spouseFather);
            return Response.of(Long.valueOf(spouseFather.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateSpouseFather(Integer id, UpdateSpouseFatherRequest updateSpouseFatherRequest) {
        try {
            this.spouseFatherDataValidator.validateUpdateSpouseFather(updateSpouseFatherRequest);
            final SpouseFather spouseFather = this.spouseFatherRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseFather.update(updateSpouseFatherRequest);
            this.spouseFatherRepository.saveAndFlush(spouseFather);
            return Response.of(Long.valueOf(spouseFather.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
 @Override
 @Transactional
 public  Response blockSpouseFather(Integer id){
        try {
            final SpouseFather spouseFather = this.spouseFatherRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseFather.setStatus(Status.DELETE);
            spouseFather.setUpdatedAt(LocalDateTime.now());
            this.spouseFatherRepository.saveAndFlush(spouseFather);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
 }
@Override
    @Transactional
    public Response unblockSpouseFather(Integer id){
        try {
            final SpouseFather spouseFather = this.spouseFatherRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseFather.setStatus(Status.ACTIVE);
            spouseFather.setUpdatedAt(LocalDateTime.now());
            this.spouseFatherRepository.saveAndFlush(spouseFather);
            return Response.of(Long.valueOf(id));
        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<SpouseFatherDTO> fetchSpouseFatherDTO(Integer pepId, Integer spouseId) {
        final SpouseFatherRowMapper rowMapper = new SpouseFatherRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE sf.pepId = ? and sf.spouseId=? AND sf.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<SpouseFatherDTO> spouseFatherDTOList  = jdbcTemplate.query(Qry,spouseFatherRowMapper,
                new Object[] {pepId,spouseId}
        );
        return spouseFatherDTOList;
    }

}
