package com.ponsun.pep.companiesAndLlp.DirectorsMaster.services;

import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.UpdateDirectorMasterRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

public interface DirectorsMasterWritePlatformService {
    Response createDirectorsMaster(CreateDirectorMasterRequest createDirectorMasterRequest);
    Integer insertDirectors(String dinNumber , CreateDirectorMasterRequest createDirectorMasterRequest);
    Response updateGetDirectors(Integer id, Integer euid, UpdateDirectorMasterRequest updateDirectorMasterRequest);
    Response updateDirector(Integer id, UpdateDirectorMasterRequest updateDirectorMasterRequest);
}
