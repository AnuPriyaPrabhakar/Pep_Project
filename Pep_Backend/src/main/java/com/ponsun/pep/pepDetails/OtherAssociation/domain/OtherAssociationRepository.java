//package com.ponsun.pep.pepDetails.OtherAssociation.domain;
//
//import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//public interface OtherAssociationRepository extends JpaRepository<OtherAssociation,Integer> {
//
//    Optional<OtherAssociation> findById(Integer id);
//    @Query(nativeQuery = true)
//    List<OtherAssociationData> findByPepId(@Param("pepId") Integer pepId);
//
//    //@Query("select u from pep_other_association u where u.pepId = ?1 and status= ?2")
//    //@Query("select u from pep_other_association u where u.pepId = :pepId and u.status = :status")
////
//    //@Query("select u from #{#OtherAssociation} u where u.pepId = ?1 and status = ?2")
//    @Query(nativeQuery = true)
//    List<OtherAssociationData> findByPepIdAndStatus(@Param("pepId") Integer pepId,
//                                                    @Param("status") String status);
//}

package com.ponsun.pep.pepDetails.OtherAssociation.domain;

import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OtherAssociationRepository extends JpaRepository<OtherAssociation,Integer> {

    Optional<OtherAssociation> findById(Integer id);
//    @Query(nativeQuery = true)
//    List<OtherAssociationData> findByPepId(@Param("pepId") Integer pepId);
        List<OtherAssociationData> findByPepId(Integer pepId);

}
