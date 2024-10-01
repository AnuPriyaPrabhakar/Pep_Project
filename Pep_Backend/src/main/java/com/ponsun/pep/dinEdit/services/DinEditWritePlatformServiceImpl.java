package com.ponsun.pep.dinEdit.services;

import com.ponsun.pep.dinEdit.data.DinEditData;
import com.ponsun.pep.dinEdit.data.DinEditDataValidator;
import com.ponsun.pep.dinEdit.domain.DinEdit;
import com.ponsun.pep.dinEdit.domain.DinEditRepository;
import com.ponsun.pep.dinEdit.request.CreateDinEditRequest;
import com.ponsun.pep.dinEdit.rowmapper.DinEditRowMapper;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DinEditWritePlatformServiceImpl implements DinEditWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final DinEditRowMapper dinEditRowMapper;
    private final DinEditDataValidator dinEditValidator;
    private final DinEditRepository dinEditRepository;

    @Override
    public List<DinEditData> fetchAllDinName(String din){
        Map <String,Object> parameters = new HashMap<>();
        parameters.put("din",din);
        final DinEditRowMapper rowMapper = new DinEditRowMapper();
            String Qry = "SELECT " + rowMapper.tableSchema();
            String whereClause = " WHERE din = ?;";
            Qry = Qry + whereClause;
            final List<DinEditData> DinData = jdbcTemplate.query(Qry,dinEditRowMapper,new Object[]{din});
            return DinData;
    }

    @Override
    public Response createDinEdit(CreateDinEditRequest createDinEditRequest){
        try{
            this.dinEditValidator.validateSaveDinEdit(createDinEditRequest);
            final DinEdit dinEdit = DinEdit.create(createDinEditRequest);
            this.dinEditRepository.saveAndFlush(dinEdit);
            return Response.of(Long.valueOf(dinEdit.getId()));
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

}
