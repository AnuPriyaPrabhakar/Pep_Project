package com.ponsun.pep.companiesAndLlp.CombinedServices.service;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;

import java.util.List;

public interface CompanyCompainedReadService {
    List<CombinedDTO> getCompanyActivity(String din);
}
