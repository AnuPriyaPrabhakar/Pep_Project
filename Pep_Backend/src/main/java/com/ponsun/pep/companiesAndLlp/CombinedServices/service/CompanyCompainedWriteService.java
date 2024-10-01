package com.ponsun.pep.companiesAndLlp.CombinedServices.service;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface CompanyCompainedWriteService {
    Integer saveCompanyActivity(List<CombinedDTO> combinedDTO);
    void EditCompanyActivity(  Integer euid ,String cin, List<CombinedDTO> combinedDTO);
}
