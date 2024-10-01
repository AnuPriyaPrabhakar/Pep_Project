package com.ponsun.pep.companiesAndLlp.DirectorsMaster.services;


import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMaster;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DirectorsMasterReadPlatformService {


    DirectorsMaster fetchDirectorsMasterById(Integer id);

    List<DirectorsMaster> fetchAllDirectorsMaster();
}
