package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.data.CompaniesAddressDataValidator;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddress;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepository;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.CreateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.UpdateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.rowmapper.CompaniesAddressRowMapper;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAddressDTO;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompaniesAddressWritePlatformServiceImpl implements CompaniesAddressWritePlatformService {
    private final CompaniesAddressRepository companiesAddressRepository;
    private final CompaniesAddressRepositoryWrapper companiesAddressRepositoryWrapper;
    private final CompaniesAddressDataValidator companiesAddressDataValidator;
    private final CompaniesAddressRowMapper companiesAddressRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createCompaniesAddress(CreateCompaniesAddressRequest createCompaniesAddressRequest){
        try {
            this.companiesAddressDataValidator.validateSaveCompaniesAddressData(createCompaniesAddressRequest);
            final CompaniesAddress companiesAddress = CompaniesAddress.create(createCompaniesAddressRequest);
            this.companiesAddressRepository.saveAndFlush(companiesAddress);
            return Response.of(Long.valueOf(companiesAddress.getId()));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateCompaniesAddress(Integer id, UpdateCompaniesAddressRequest updateCompaniesAddressRequest) {
        try {
            this.companiesAddressDataValidator.validateUpdateCompaniesAddressData(updateCompaniesAddressRequest);
            final CompaniesAddress companiesAddress = this.companiesAddressRepositoryWrapper.findOneWithNotFoundDetection(id);
            companiesAddress.update(updateCompaniesAddressRequest);
            this.companiesAddressRepository.saveAndFlush(companiesAddress);
            return Response.of(Long.valueOf(companiesAddress.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deActive(Integer companyId, Integer euid){
        try{
            List<CompaniesAddress> companiesAddresses = this.companiesAddressRepositoryWrapper.findOnePepIdWithNotFoundDetection(companyId);
            Response response = null;
            for (CompaniesAddress address : companiesAddresses) {
                address.setEuid(euid);
                address.setStatus(Status.DELETE);
                address.setUpdatedAt(LocalDateTime.now());

                this.companiesAddressRepository.save(address);
                response = Response.of(address.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockCompaniesAddress(Integer id){
        try{
            final CompaniesAddress companiesAddress = this.companiesAddressRepositoryWrapper.findOneWithNotFoundDetection(id);
            companiesAddress.setStatus(Status.DELETE);
            companiesAddress.setUpdatedAt(LocalDateTime.now());
            this.companiesAddressRepository.saveAndFlush(companiesAddress);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockCompaniesAddress(Integer id){
        try {
            final CompaniesAddress companiesAddress = this.companiesAddressRepositoryWrapper.findOneWithNotFoundDetection(id);
            companiesAddress.setStatus(Status.ACTIVE);
            companiesAddress.setUpdatedAt(LocalDateTime.now());
            this.companiesAddressRepository.saveAndFlush(companiesAddress);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CompanyAddressDTO> fetchAllCompaniesAddressData(Integer companyId) {
        final CompaniesAddressRowMapper rowMapper = new CompaniesAddressRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cd.companyId = ? AND cd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CompanyAddressDTO> companyAddressDTOList  = jdbcTemplate.query(Qry,companiesAddressRowMapper,
                new Object[] {companyId}
        );
        return companyAddressDTOList;
    }
}
