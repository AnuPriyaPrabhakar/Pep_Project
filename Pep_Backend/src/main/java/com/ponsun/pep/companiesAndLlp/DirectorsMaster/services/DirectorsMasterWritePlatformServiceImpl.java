package com.ponsun.pep.companiesAndLlp.DirectorsMaster.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.data.DirectorsMasterDataValidator;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMaster;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepository;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.UpdateDirectorMasterRequest;
import com.ponsun.pep.dinEdit.domain.DinEdit;
import com.ponsun.pep.dinEdit.domain.DinEditRepository;
import com.ponsun.pep.dinEdit.domain.DinEditRepositoryWrapper;
import com.ponsun.pep.dinEdit.request.CreateDinEditRequest;
import com.ponsun.pep.getDirectors.data.DirectorsValidator;
import com.ponsun.pep.getDirectors.domain.GetDirectors;
import com.ponsun.pep.getDirectors.domain.GetDirectorsRepository;
import com.ponsun.pep.getDirectors.request.CreateGetDirectorsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DirectorsMasterWritePlatformServiceImpl implements DirectorsMasterWritePlatformService {
    private final DirectorsMasterRepository directorsMasterRepository;
    private final DirectorsMasterRepositoryWrapper directorsMasterRepositoryWrapper;
    private final DirectorsMasterDataValidator directorsMasterDataValidator;
    private final DirectorsValidator directorsValidator;
    private final GetDirectorsRepository getDirectorsRepository;
    private final DinEditRepository dinEditRepository;
    private final DinEditRepositoryWrapper dinEditRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Response createDirectorsMaster(CreateDirectorMasterRequest createDirectorMasterRequest) {
        try {
            this.directorsMasterDataValidator.validateSaveDirectorsMaster(createDirectorMasterRequest);
            final DirectorsMaster directorsMaster = DirectorsMaster.create(createDirectorMasterRequest);
            this.directorsMasterRepository.saveAndFlush(directorsMaster);
            return Response.of(Long.valueOf(directorsMaster.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Integer insertDirectors(String dinNumber, CreateDirectorMasterRequest createDirectorMasterRequest) {
        Integer id = 0;
        try {
            String selectQuery = " SELECT id FROM pep_config_companies_directors WHERE din = '" + dinNumber + "' LIMIT 1 ";
            List strLst = jdbcTemplate.query(selectQuery, new RowMapper() {
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getString("id");
                }
            });
            if (strLst.isEmpty()) {
                id = 0;
            } else if (strLst.size() == 1) {
                id = Integer.parseInt(strLst.get(0).toString());
            }
        } catch (EQAS_PEP_AppicationException ex) {
            id = -1;
        }
        if (id <= 0) {
            DirectorsMaster directorsMaster = DirectorsMaster.create(createDirectorMasterRequest);
            DirectorsMaster response = this.directorsMasterRepository.saveAndFlush(directorsMaster);
            id = response.getId();
        }
        return id;
    }

    @Override
    @Transactional
    public Response updateGetDirectors(Integer id, Integer euid, UpdateDirectorMasterRequest updateDirectorMasterRequest) {
        try {
            ModelMapper modelMapper = new ModelMapper();

            this.directorsMasterDataValidator.validateUpdateDirectorsMaster(updateDirectorMasterRequest);
            DirectorsMaster directorsMaster = this.directorsMasterRepositoryWrapper.findOneWithNotFoundDetection(id);

            CreateDirectorMasterRequest createDirectorMasterRequest = modelMapper.map(updateDirectorMasterRequest, CreateDirectorMasterRequest.class);
            this.directorsMasterDataValidator.validateSaveDirectorsMaster(createDirectorMasterRequest);

            GetDirectors getDirectors = modelMapper.map(createDirectorMasterRequest, GetDirectors.class);
            getDirectors.setStatus(Status.ACTIVE);
            this.getDirectorsRepository.saveAndFlush(getDirectors);

            directorsMaster.update(updateDirectorMasterRequest);
            this.directorsMasterRepository.saveAndFlush(directorsMaster);

            return Response.of(Integer.valueOf(directorsMaster.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

//    @Override
//    @Transactional
//    public Response updateDirector(Integer id, UpdateDirectorMasterRequest updateDirectorMasterRequest) {
//        try{
//            ModelMapper modelMapper = new ModelMapper();
//
//            this.directorsMasterDataValidator.validateUpdateDirectorsMaster(updateDirectorMasterRequest);
//            DirectorsMaster directorsMaster = this.directorsMasterRepositoryWrapper.findOneWithNotFoundDetection(id);
//            System.out.println("directorsMaster:"+directorsMaster);
//
//            CreateDirectorMasterRequest createDirectorMasterRequest = modelMapper.map(updateDirectorMasterRequest,CreateDirectorMasterRequest.class);
//            System.out.println("createDirectorMasterRequest:"+createDirectorMasterRequest);
//            this.directorsMasterDataValidator.validateSaveDirectorsMaster(createDirectorMasterRequest);
//
//            directorsMaster.update(updateDirectorMasterRequest);
//            this.directorsMasterRepository.saveAndFlush(directorsMaster);
//
//            return Response.of(Integer.valueOf(directorsMaster.getId()));
//        } catch(DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }

    @Override
    @Transactional
    public Response updateDirector(Integer id, UpdateDirectorMasterRequest updateDirectorMasterRequest) {
        try {
            ModelMapper modelMapper = new ModelMapper();

            this.directorsMasterDataValidator.validateUpdateDirectorsMaster(updateDirectorMasterRequest);
            DirectorsMaster directorsMaster = this.directorsMasterRepositoryWrapper.findOneWithNotFoundDetection(id);

            CreateDirectorMasterRequest createDirectorMasterRequest = modelMapper.map(updateDirectorMasterRequest,CreateDirectorMasterRequest.class);
            this.directorsMasterDataValidator.validateSaveDirectorsMaster(createDirectorMasterRequest);

            DinEdit dinEdit = new DinEdit();
            dinEdit.setName(directorsMaster.getName());
            dinEdit.setDin(directorsMaster.getDin());
            dinEdit.setUid(directorsMaster.getUid());
            dinEdit.setEuid(directorsMaster.getEuid());
            dinEdit.setStatus(Status.ACTIVE);

            this.dinEditRepository.saveAndFlush(dinEdit);

            directorsMaster.update(updateDirectorMasterRequest);

            this.directorsMasterRepository.saveAndFlush(directorsMaster);

            return Response.of(Integer.valueOf(directorsMaster.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


//     @Override
//     @Transactional
//    public Response updateDirector(Integer id, UpdateDirectorMasterRequest updateDirectorMasterRequest) {
//        return directorsMasterRepository.findById(id).map(directorsMaster -> {
//            directorsMaster.deactive(updateDirectorMasterRequest);
//            directorsMasterRepository.save(directorsMaster);
//            return new Response("Director deactivated successfully");
//        }).orElse(new Response("Director not found"));
//    }

}
