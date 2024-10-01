//package com.ponsun.pep.searchDetails.domain;
//
//import com.ponsun.pep.searchDetails.request.AbstractSearchDetailsRequest;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class SearchDetailsRepositoryWrapper extends AbstractSearchDetailsRequest {
//    private final SearchDetailsRepository searchDetailsRepository;
//
//    @Transactional
//    public SearchDetails findOneWithNotFoundDetection(final Integer id){
//        return this.searchDetailsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("SearchDetails Not found "+id));
//    }
//    @Override
//    public String toString(){return super.toString();}
//}


package com.ponsun.pep.searchDetails.domain;

import com.ponsun.pep.searchDetails.request.AbstractSearchDetailsBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SearchDetailsRepositoryWrapper extends AbstractSearchDetailsBaseRequest {
    private final SearchDetailsRepository searchDetailsRepository;
    @Transactional
    public SearchDetails findOneWithNotFoundDetection(final Integer id){
        return this.searchDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("SearchDetails Not Found" + id));
    }
    @Override
    public String toString() {return super.toString();}
}

