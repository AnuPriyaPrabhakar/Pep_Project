package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services;


import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompaniesDirectorsDTO;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.CreatCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.UpdateCompaniesDirectorsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface CompaniesDirectorsWritePlatformService {

    Response createCompaniesDirectors(CreatCompaniesDirectorsRequest creatCompaniesDirectorsRequest);

    Response updateCompaniesDirectors(Integer id, UpdateCompaniesDirectorsRequest updateCompaniesDirectorsRequest);

    Response blockCompaniesDirectors(Integer id);

    Response unblockCompaniesDirectors(Integer id);

    Response deActive(Integer companyId, Integer euid);

    List<CompaniesDirectorsDTO> fetchAllCompaniesDirectorsData(Integer companyId);

}
