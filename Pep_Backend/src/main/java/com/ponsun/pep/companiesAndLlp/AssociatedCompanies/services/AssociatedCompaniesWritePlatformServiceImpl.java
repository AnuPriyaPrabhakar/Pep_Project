package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddressRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data.AssociatedCompaniesData;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepository;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompaniesRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.CreateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.UpdateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.rowmapper.AssociatedCompaniesRowMapper;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDetRepository;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
@RequiredArgsConstructor
@Slf4j

public class AssociatedCompaniesWritePlatformServiceImpl implements AssociatedCompaniesWritePlatformService{
    private final AssociatedCompaniesRepository associatedCompaniesRepository;
    private final AssCompanyContactDetRepository contactDetRepository;
    private final CompaniesAddressRepository addressRepository;
    private final AssociatedCompaniesRepositoryWrapper associatedCompaniesRepositoryWrapper;
    private final AssociatedCompaniesRowMapper associatedCompaniesRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public Response createAssociatedCompanies(CreateAssociatedCompaniesRequest createAssociatedCompaniesRequest){
        try{
            final AssociatedCompanies associatedCompanies = AssociatedCompanies.create(createAssociatedCompaniesRequest);
            this.associatedCompaniesRepository.saveAndFlush(associatedCompanies);
            return Response.of(Long.valueOf(associatedCompanies.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
//    @Override
//    @Transactional
//    public Integer insertAssociatedCompanies(String companyName, String CINFCRN , Integer associateMasterId , String originalDateOfAppointment,String sourceLink,Integer typeId,Integer listAdverseInformation,Integer listRegulatoryAction,Integer listGovernment) {
//        Integer id = 0;
//        try {
//            String checkExistsQuery = "SELECT id FROM pep_associated_companies WHERE  CINFCRN = ?";
//            List<Integer> existingIds = jdbcTemplate.queryForList(checkExistsQuery, Integer.class,  CINFCRN);
//
//            if (!existingIds.isEmpty()) {
//                id = existingIds.get(0);
//                System.out.println("Record already exists:"+ existingIds);
//
//            } else {
//                String insertQuery = "INSERT INTO pep_associated_companies (companyName, CINFCRN, associateMasterId, originalDateOfAppointment, sourceLink, typeId, listAdverseInformation, listRegulatoryAction, listGovernment, created_at, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), 'A')";
//                int rowsAffected = jdbcTemplate.update(insertQuery, companyName, CINFCRN, associateMasterId, originalDateOfAppointment, sourceLink, typeId, listAdverseInformation, listRegulatoryAction, listGovernment);
//
//                if (rowsAffected > 0) {
//                    String selectIdQuery = "SELECT id FROM pep_associated_companies WHERE CINFCRN = ?";
//                    id = jdbcTemplate.queryForObject(selectIdQuery, Integer.class, CINFCRN);
//                }
//            }
//        } catch (DataAccessException ex) {
//            id = -1;
//            ex.printStackTrace();
//        }
//        System.out.println("id:" + id);
//        return id;
//    }


    @Override
    @Transactional
    public Integer insertAssociatedCompanies(String companyName, String CINFCRN , Integer associateMasterId , String originalDateOfAppointment, String sourceLink, Integer typeId, Integer listAdverseInformation, Integer listRegulatoryAction, Integer listGovernment) {
        Integer id = 0;
        try {
            String checkExistsQuery = "SELECT id FROM pep_associated_companies WHERE CINFCRN = ?";
            List<Integer> existingIds = jdbcTemplate.queryForList(checkExistsQuery, Integer.class, CINFCRN);

            if (!existingIds.isEmpty()) {
                id = existingIds.get(0);
                System.out.println("Record already exists: " + existingIds);
            } else {
                String insertQuery = "INSERT INTO pep_associated_companies (companyName, CINFCRN, associateMasterId, originalDateOfAppointment, sourceLink, typeId, listAdverseInformation, listRegulatoryAction, listGovernment, created_at, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), 'A')";
                int rowsAffected = jdbcTemplate.update(insertQuery, companyName, CINFCRN, associateMasterId, originalDateOfAppointment, sourceLink, typeId, listAdverseInformation, listRegulatoryAction, listGovernment);

                if (rowsAffected > 0) {
                    String selectIdQuery = "SELECT id FROM pep_associated_companies WHERE CINFCRN = ?";
                    id = jdbcTemplate.queryForObject(selectIdQuery, Integer.class, CINFCRN);
                } else {
                    System.out.println("Failed to insert company: " + companyName);
                }
            }
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }
        System.out.println("id: " + id);
        return id;
    }


    @Override
    @Transactional
    public Response updateAssociatedCompanies(Integer id, UpdateAssociatedCompaniesRequest updateAssociatedCompaniesRequest){
        try{
            AssociatedCompanies associatedCompanies = this.associatedCompaniesRepositoryWrapper.findOneWithNotFoundDetection(id);
            associatedCompanies.setCINFCRN(updateAssociatedCompaniesRequest.getCINFCRN());
            associatedCompanies.setCompanyName(updateAssociatedCompaniesRequest.getCompanyName());
            associatedCompanies.setOriginalDateOfAppointment(updateAssociatedCompaniesRequest.getOriginalDateOfAppointment());
            associatedCompanies.setAssociateMasterId(updateAssociatedCompaniesRequest.getAssociateMasterId());
            associatedCompanies.setStatus(Status.ACTIVE);
            associatedCompanies.setUpdatedAt(LocalDateTime.now());
            return Response.of(Long.valueOf(associatedCompanies.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
//    @Override
//    @Transactional
//     public Response deactive(Integer id, Integer euid){
//        try{
//            AssociatedCompanies associatedCompanies = this.associatedCompaniesRepositoryWrapper.findOneWithNotFoundDetection(id);
//            Response response = null;
//            final AssociatedCompanies associatedCompanies1 = new AssociatedCompanies();
//            associatedCompanies1.setEuid(euid);
//            associatedCompanies1.setStatus(Status.DELETE);
//            associatedCompanies1.setUpdatedAt(LocalDateTime.now());
//                response = Response.of(associatedCompanies1.getId());
//            return response;
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }

    @Override
    @Transactional
    public Response deactive(Integer id, Integer euid) {
        try {
            AssociatedCompanies associatedCompanies = this.associatedCompaniesRepositoryWrapper.findOneWithNotFoundDetection(id);
            associatedCompanies.setStatus(Status.DELETE);
            associatedCompanies.setUpdatedAt(LocalDateTime.now());
            this.associatedCompaniesRepositoryWrapper.save(associatedCompanies);
            return Response.of(associatedCompanies.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deleteAssociatedCompanies(Integer id){
        try{
            Optional<AssociatedCompanies> optionalAssociatedCompanies = associatedCompaniesRepository.findById(id);
            if(optionalAssociatedCompanies.isPresent()){
                associatedCompaniesRepository.delete(optionalAssociatedCompanies.get());
                return Response.of(Long.valueOf(id));
            }else{
                throw new EntityNotFoundException("Associated Companies not found with ID: "+id);
            }
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    public List<AssociatedCompaniesData> fetchAssociatedCompaniesData(String din) {
        final AssociatedCompaniesRowMapper rowMapper = new AssociatedCompaniesRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
//        String whereClause = " WHERE a.directorsIdentificationNumber=b.din AND b.id=d.directorId AND c.id=d.companyId AND a.directorsIdentificationNumber= '"+din+"' AND c.status = 'A' AND d.status = 'A'";
        String whereClause = " WHERE a.directorsIdentificationNumber=b.din AND b.id=d.directorId AND c.id=d.companyId AND a.directorsIdentificationNumber= '"+din+"' AND c.status = 'A' AND d.status = 'A'  GROUP BY c.id";
//        System.out.println("whereClause: "+ whereClause);
        Qry = Qry + whereClause;
        final List<AssociatedCompaniesData> associatedCompaniesData  = jdbcTemplate.query(Qry,associatedCompaniesRowMapper,
                new Object[] {}
        );
        return associatedCompaniesData;
    }
}
