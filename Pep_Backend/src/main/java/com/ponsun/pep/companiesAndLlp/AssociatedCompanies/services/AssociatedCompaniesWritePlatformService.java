package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services;

import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data.AssociatedCompaniesData;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.CreateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.UpdateAssociatedCompaniesRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AssociatedCompaniesWritePlatformService {
    Response createAssociatedCompanies(CreateAssociatedCompaniesRequest createAssociatedCompaniesRequest);
    Response updateAssociatedCompanies(Integer id, UpdateAssociatedCompaniesRequest updateAssociatedCompaniesRequest);
    Response deleteAssociatedCompanies(Integer id);
    Response deactive(Integer companyId, Integer euid);
    List<AssociatedCompaniesData> fetchAssociatedCompaniesData(String din);
    Integer insertAssociatedCompanies(String companyName, String CINFCRN, Integer associateMasterId , String originalDateOfAppointmenttypeId, String sourceLink,Integer typeId,Integer listAdverseInformation,Integer listRegulatoryAction,Integer listGovernment);
}
