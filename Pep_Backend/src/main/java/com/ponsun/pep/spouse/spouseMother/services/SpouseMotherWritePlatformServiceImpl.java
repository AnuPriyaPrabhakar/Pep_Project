package com.ponsun.pep.spouse.spouseMother.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseMotherDTO;
import com.ponsun.pep.spouse.spouseMother.data.SpouseMotherDataValidator;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMother;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMotherRepository;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMotherRepositoryWrapper;
import com.ponsun.pep.spouse.spouseMother.request.UpdateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.request.CreateSpouseMotherRequest;
import com.ponsun.pep.spouse.spouseMother.rowmapper.SpouseMotherRowMapper;
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
public class SpouseMotherWritePlatformServiceImpl implements SpouseMotherWritePlatformService {

    private final SpouseMotherRepository spouseHufRepository;
    private final SpouseMotherRepositoryWrapper spouseHufRepositoryWrapper;
    private final SpouseMotherDataValidator spouseMotherDataValidator;
    private final SpouseMotherRowMapper spouseMotherRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createSpouseMother(CreateSpouseMotherRequest createSpouseMotherRequest) {
        try {
            this.spouseMotherDataValidator.validateSaveSpouseMother(createSpouseMotherRequest);
            final SpouseMother spouseMother = SpouseMother.create(createSpouseMotherRequest);
            this.spouseHufRepository.saveAndFlush(spouseMother);
            return Response.of(Long.valueOf(spouseMother.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateSpouseMother(Integer id, UpdateSpouseMotherRequest updateSpouseMotherRequest) {
        try {
            this.spouseMotherDataValidator.validateUpdateSpouseMother(updateSpouseMotherRequest);
            final SpouseMother spouseMother = this.spouseHufRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseMother.update(updateSpouseMotherRequest);
            this.spouseHufRepository.saveAndFlush(spouseMother);
            return Response.of(Long.valueOf(spouseMother.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
 @Override
 @Transactional
 public  Response blockSpouseMother(Integer id){
        try {
            final SpouseMother spouseMother = this.spouseHufRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseMother.setStatus(Status.DELETE);
            spouseMother.setUpdatedAt(LocalDateTime.now());
            this.spouseHufRepository.saveAndFlush(spouseMother);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
 }
@Override
    @Transactional
    public Response unblockSpouseMother(Integer id){
        try {
            final SpouseMother spouseMother = this.spouseHufRepositoryWrapper.findOneWithNotFoundDetection(id);
            spouseMother.setStatus(Status.ACTIVE);
            spouseMother.setUpdatedAt(LocalDateTime.now());
            this.spouseHufRepository.saveAndFlush(spouseMother);
            return Response.of(Long.valueOf(id));
        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<SpouseMotherDTO> fetchSpouseMotherDTO(Integer pepId, Integer spouseId) {
        final SpouseMotherRowMapper rowMapper = new SpouseMotherRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE sm.pepId = ? and sm.spouseId=? AND sm.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<SpouseMotherDTO> spouseMotherDTOList  = jdbcTemplate.query(Qry,spouseMotherRowMapper,
                new Object[] {pepId,spouseId}
        );
        return spouseMotherDTOList;
    }
}
