package com.ponsun.pep.companiesAndLlp.CombinedServices.service;

import com.ponsun.pep.FilesStorage.service.FileStorageReadPlatformService;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepository;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services.CompaniesAddressWritePlatformService;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data.AssociatedCompaniesData;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services.AssociatedCompaniesWritePlatformService;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services.AssCompanyContactDetWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.*;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services.CompaniesDirectorsWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.services.CompanyAssociationWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyCompainedReadServiceImpl implements CompanyCompainedReadService {
    final private AssociatedCompaniesRepository companiesRepository;
    final private AssCompanyContactDetRepository contactDetRepository;
    final private CompaniesAddressRepository addressRepository;

    final private CompanyAssociationWritePlatformService companyAssociationWritePlatformService;
    final private CompaniesAddressWritePlatformService companiesAddressWritePlatformService;
    final private AssociatedCompaniesWritePlatformService associatedCompaniesWritePlatformService;
    final private AssCompanyContactDetWritePlatformService assCompanyContactDetWritePlatformService;
    final private CompaniesDirectorsWritePlatformService companiesDirectorsWritePlatformService;
    final private FileStorageReadPlatformService fileStorageReadPlatformService;
    final private ModelMapper modelMapper;

    public List<CombinedDTO> getCompanyActivity(String din) {

        List<AssociatedCompaniesData> associatedCompaniesDataList = associatedCompaniesWritePlatformService.fetchAssociatedCompaniesData(din);
        ModelMapper modelMapper = new ModelMapper();
        List<CombinedDTO> combinedDTOList = new ArrayList<>();

        for (AssociatedCompaniesData associatedCompaniesData : associatedCompaniesDataList) {
            CombinedDTO combinedDTO = new CombinedDTO();
            CompanyDTO companyDTO = modelMapper.map(associatedCompaniesData, CompanyDTO.class);
            Integer companyId = companyDTO.getId();
            List<CompanyAddressDTO> companiesAddressDataList = companiesAddressWritePlatformService.fetchAllCompaniesAddressData(companyId);
            List<CompanyContactDTO> assCompanyContactDetDataList = assCompanyContactDetWritePlatformService.fetchAllAssCompanyContactDetData(companyId);
            List<CompaniesDirectorsDTO>  companiesDirectorsDTOList = companiesDirectorsWritePlatformService.fetchAllCompaniesDirectorsData(companyId);
            List<CompanyAssociationDTO> companyAssociationDTOList = companyAssociationWritePlatformService.fetchAllAsCompanyAssociationData(companyId);
            List<String> filesForCompany = fileStorageReadPlatformService.getCompanyFiles(companyId);

            companyDTO.setDocument(filesForCompany);

            combinedDTO.setCompanyDTO(companyDTO);
            combinedDTO.setContactDTOS(assCompanyContactDetDataList);
            combinedDTO.setAddressDTOS(companiesAddressDataList);
            combinedDTO.setCompaniesDirectorsDTOS(companiesDirectorsDTOList);
            combinedDTO.setCompanyAssociationDTOS(companyAssociationDTOList);
            combinedDTOList.add(combinedDTO);
        }
        return combinedDTOList;
    }
}
