//package com.ponsun.pep.searchDetails.domain;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface SearchDetailsRepository extends JpaRepository<SearchDetails,Integer> {
//
//    Optional<SearchDetails> findById(Integer id);
//}


package com.ponsun.pep.searchDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchDetailsRepository extends JpaRepository<SearchDetails,Integer> {
}
