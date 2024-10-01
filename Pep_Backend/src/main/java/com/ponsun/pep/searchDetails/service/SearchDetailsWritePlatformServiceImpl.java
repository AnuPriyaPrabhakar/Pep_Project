//package com.ponsun.pep.searchDetails.service;
//
//import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
//import com.ponsun.pep.infrastructure.utils.Response;
//import com.ponsun.pep.searchDetails.data.SearchDetailsDataValidator;
//import com.ponsun.pep.searchDetails.domain.SearchDetails;
//import com.ponsun.pep.searchDetails.domain.SearchDetailsRepository;
//import com.ponsun.pep.searchDetails.domain.SearchDetailsRepositoryWrapper;
//import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class SearchDetailsWritePlatformServiceImpl implements SearchDetailsWritePlatformService {
//   private final SearchDetailsRepository searchDetailsRepository;
//   private final SearchDetailsRepositoryWrapper searchDetailsRepositoryWrapper;
//   private final SearchDetailsDataValidator searchDetailsDataValidator;
//
//   @Transactional
//    public Response createSearchDetails(CreateSearchDetailsRequest createSearchDetailsRequest){
//       try{
//           //this.searchDetailsDataValidator.validateSaveSearchDetails(createSearchDetailsRequest);
//           final SearchDetails searchDetails = SearchDetails.create(createSearchDetailsRequest);
//           this.searchDetailsRepository.saveAndFlush(searchDetails);
//           return Response.of(Long.valueOf(searchDetails.getId()));
//       }catch (DataIntegrityViolationException e){
//           throw new EQAS_PEP_AppicationException(e.getMessage());
//       }
//   }
//
//}


package com.ponsun.pep.searchDetails.service;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchDetails.domain.SearchDetails;
import com.ponsun.pep.searchDetails.domain.SearchDetailsRepository;
import com.ponsun.pep.searchDetails.domain.SearchDetailsRepositoryWrapper;
import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.pep.searchDetails.request.UpdateSearchDetailsRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchDetailsWritePlatformServiceImpl implements SearchDetailsWritePlatformService {
    private final SearchDetailsRepository searchDetailsRepository;
    private final SearchDetailsRepositoryWrapper searchDetailsRepositoryWrapper;
    @Override
    @Transactional
    public Response createSearchDetails(CreateSearchDetailsRequest createSearchDetailsRequest){
        try{
            SearchDetails searchDetails = SearchDetails.create(createSearchDetailsRequest);
            searchDetails = this.searchDetailsRepository.saveAndFlush(searchDetails);
            return Response.of(searchDetails.getId());
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateSearchDetails(Integer id, UpdateSearchDetailsRequest updateSearchDetailsRequest){
        try{
            final SearchDetails searchDetails = this.searchDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            searchDetails.update(updateSearchDetailsRequest);
            this.searchDetailsRepository.saveAndFlush(searchDetails);
            return Response.of(Long.valueOf(searchDetails.getId()));
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}

