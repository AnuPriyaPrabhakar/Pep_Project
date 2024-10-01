package com.ponsun.pep.companiesAndLlp.CombinedServices.service;

import com.ponsun.pep.FilesStorage.service.FileStorageReadPlatformService;
import com.ponsun.pep.FilesStorage.service.FileStorageWritePlatformService;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddress;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepository;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.CreateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services.CompaniesAddressWritePlatformService;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data.AssociatedCompaniesData;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.CreateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.rowmapper.AssociatedCompaniesRowMapper;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services.AssociatedCompaniesWritePlatformService;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDet;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.CreateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services.AssCompanyContactDetWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.*;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectors;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectorsRepository;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.CreatCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services.CompaniesDirectorsWritePlatformServiceImpl;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociation;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociationRepository;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.CreateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.services.CompanyAssociationWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocumentsRepository;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.services.DirectorsMasterWritePlatformService;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services.DocumentTypeMasterWritePlatformServiceImpl;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyCompainedWriteServiceImpl implements CompanyCompainedWriteService {
    private final AssociatedCompaniesRepository companiesRepository;
    private final AssCompanyContactDetRepository contactDetRepository;
    private final CompaniesAddressRepository addressRepository;
    private final CompaniesDirectorsRepository companiesDirectorsRepository;
    private final CompanyDocumentsRepository companyDocumentsRepository;
    private final FileStorageWritePlatformService fileStorageWritePlatformService;
    private final FileStorageReadPlatformService fileStorageReadPlatformService;
    private final CompanyAssociationRepository companyAssociationRepository;
    private final AssociatedCompaniesRepositoryWrapper associatedCompaniesRepositoryWrapper;

    private final AssociatedCompaniesWritePlatformService associatedCompaniesWritePlatformService;
    private final AssCompanyContactDetWritePlatformService assCompanyContactDetWritePlatformService;
    private final CompaniesAddressWritePlatformService companiesAddressWritePlatformService;
    private final CompaniesDirectorsWritePlatformServiceImpl companiesDirectorsWritePlatformService;
    private final DocumentTypeMasterWritePlatformServiceImpl documentTypeMasterWritePlatformService;
    private final DirectorsMasterWritePlatformService directorsMasterWritePlatformService;
    private final CompanyAssociationWritePlatformService companyAssociationWritePlatformService;

    @Transactional
    public Integer saveCompanyActivity(List<CombinedDTO> combinedDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            Integer companyId = 0;
            for (CombinedDTO dto : combinedDTO) {
                CompanyDTO companyDTO = dto.getCompanyDTO();
                if (companyDTO != null && !companyDTO.getCompanyName().isEmpty()) {
                    CreateAssociatedCompaniesRequest request = modelMapper.map(companyDTO, CreateAssociatedCompaniesRequest.class);
                    AssociatedCompanies associatedCompanies = AssociatedCompanies.create(request);

                    String companyName = associatedCompanies.getCompanyName();
                    String CIN = request.getCINFCRN();
                    Integer associateMasterId = request.getAssociateMasterId();
                    String originalDateOfAppointment = request.getOriginalDateOfAppointment();
                    String sourceLink = request.getSourceLink();
                    Integer typeId = request.getTypeId();
                    Integer listAdverseInformation = request.getListAdverseInformation();
                    Integer listRegulatoryAction = request.getListRegulatoryAction();
                    Integer listGovernment = request.getListGovernment();

                    companyId = this.associatedCompaniesWritePlatformService.insertAssociatedCompanies(
                            companyName, CIN, associateMasterId, originalDateOfAppointment,
                            sourceLink, typeId, listAdverseInformation, listRegulatoryAction, listGovernment
                    );

                    if (companyId == 0) {
                        AssociatedCompanies newAssociatedCompanies = AssociatedCompanies.create(request);
                        newAssociatedCompanies = this.companiesRepository.save(newAssociatedCompanies);
                        companyId = newAssociatedCompanies.getId();
                    }
                }

                for (CompanyContactDTO contactDTO : dto.getContactDTOS()) {
                    if (!contactDTO.getEmailID().isEmpty()) {
                        CreateAssCompanyContactDetRequest contactDetrequest = modelMapper.map(contactDTO, CreateAssCompanyContactDetRequest.class);
                        contactDetrequest.setCompanyId(companyId);
                        final AssCompanyContactDet assCompanyContactDet = AssCompanyContactDet.create(contactDetrequest);
                        this.contactDetRepository.save(assCompanyContactDet);
                    }
                }

                for (CompanyAddressDTO addressDTO : dto.getAddressDTOS()) {
                    CreateCompaniesAddressRequest companiesAddressRequest = modelMapper.map(addressDTO, CreateCompaniesAddressRequest.class);
                    companiesAddressRequest.setCompanyId(companyId);
                    final CompaniesAddress companiesAddress = CompaniesAddress.create(companiesAddressRequest);
                    this.addressRepository.save(companiesAddress);
                }

                for (CompaniesDirectorsDTO directorsDTO : dto.getCompaniesDirectorsDTOS()) {
                    CreatCompaniesDirectorsRequest directorsRequest = modelMapper.map(directorsDTO, CreatCompaniesDirectorsRequest.class);
                    CreateDirectorMasterRequest masterRequest = modelMapper.map(directorsDTO, CreateDirectorMasterRequest.class);
                    Integer director_id = this.directorsMasterWritePlatformService.insertDirectors(directorsDTO.getDin(), masterRequest);
                    directorsRequest.setCompanyId(companyId);
                    directorsRequest.setDirectorId(director_id);
                    final CompaniesDirectors companiesDirectors = CompaniesDirectors.create(directorsRequest);
                    this.companiesDirectorsRepository.save(companiesDirectors);
                }

                for (CompanyAssociationDTO companyAssociationDTO : dto.getCompanyAssociationDTOS()) {
                    CreateCompanyAssociationRequest createCompanyAssociationRequest = modelMapper.map(companyAssociationDTO, CreateCompanyAssociationRequest.class);
                    createCompanyAssociationRequest.setCompanyId(companyId);
                    final CompanyAssociation companyAssociation = CompanyAssociation.create(createCompanyAssociationRequest);
                    this.companyAssociationRepository.save(companyAssociation);
                }
            }

            return companyId;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Transactional
    public void EditCompanyActivity(Integer euid, String cin, List<CombinedDTO> combinedDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
                if(cin.length()>0)
                {
                List<AssociatedCompaniesData> associatedCompaniesData = this.associatedCompaniesWritePlatformService.fetchAssociatedCompaniesData(cin);

                    for (AssociatedCompaniesData dto : associatedCompaniesData) {
                    Integer companyId = dto.getId();//companyId
                        if (companyId != 0) {
                        System.out.println("companyId : "+companyId);

                        this.associatedCompaniesWritePlatformService.deactive(companyId, euid);
                        this.assCompanyContactDetWritePlatformService.deactive(companyId, euid);
                        this.companiesAddressWritePlatformService.deActive(companyId, euid); //company Address
                        this.companiesDirectorsWritePlatformService.deActive(companyId, euid);
                        this.companyAssociationWritePlatformService.deActive(companyId, euid);
                        }
                    }
                }

            for (CombinedDTO dto : combinedDTO) {
                CreateAssociatedCompaniesRequest request = modelMapper.map(dto.getCompanyDTO(), CreateAssociatedCompaniesRequest.class);
                Integer companyId = 0;//companyId

                AssociatedCompanies newAssociatedCompanies = AssociatedCompanies.create(request);
                newAssociatedCompanies = this.companiesRepository.save(newAssociatedCompanies);
                companyId = newAssociatedCompanies.getId();

                for (CompanyContactDTO contactDTO : dto.getContactDTOS()) {
                    CreateAssCompanyContactDetRequest contactDetRequest = modelMapper.map(contactDTO, CreateAssCompanyContactDetRequest.class);
                    contactDetRequest.setCompanyId(companyId);
                    final AssCompanyContactDet assCompanyContactDet = AssCompanyContactDet.create(contactDetRequest);
                    this.contactDetRepository.save(assCompanyContactDet);
                }

                for (CompanyAddressDTO addressDTO : dto.getAddressDTOS()) {
                    CreateCompaniesAddressRequest companiesAddressRequest = modelMapper.map(addressDTO, CreateCompaniesAddressRequest.class);
                    companiesAddressRequest.setCompanyId(companyId);
                    final CompaniesAddress companiesAddress = CompaniesAddress.create(companiesAddressRequest);
                    this.addressRepository.save(companiesAddress);
                }

                for (CompaniesDirectorsDTO directorsDTO : dto.getCompaniesDirectorsDTOS()) {
                    CreatCompaniesDirectorsRequest directorsRequest = modelMapper.map(directorsDTO, CreatCompaniesDirectorsRequest.class);
                    CreateDirectorMasterRequest masterRequest = modelMapper.map(directorsDTO, CreateDirectorMasterRequest.class);

                    Integer director_id = this.directorsMasterWritePlatformService.insertDirectors(directorsDTO.getDin(), masterRequest);
                    directorsRequest.setCompanyId(companyId);
                    directorsRequest.setDirectorId(director_id);
                    final CompaniesDirectors companiesDirectors = CompaniesDirectors.create(directorsRequest);
                    this.companiesDirectorsRepository.save(companiesDirectors);
                }

                for (CompanyAssociationDTO companyAssociationDTO : dto.getCompanyAssociationDTOS()) {
                    CreateCompanyAssociationRequest createCompanyAssociationRequest = modelMapper.map(companyAssociationDTO, CreateCompanyAssociationRequest.class);
                    createCompanyAssociationRequest.setCompanyId(companyId);
                    final CompanyAssociation companyAssociation = CompanyAssociation.create(createCompanyAssociationRequest);
                    this.companyAssociationRepository.save(companyAssociation);
                }
            }
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
