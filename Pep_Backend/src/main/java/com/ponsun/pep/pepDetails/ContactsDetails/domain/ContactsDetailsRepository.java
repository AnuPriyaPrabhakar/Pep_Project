package com.ponsun.pep.pepDetails.ContactsDetails.domain;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
public interface ContactsDetailsRepository extends JpaRepository<ContactsDetails,Integer> {
    Optional<ContactsDetails> findById(Integer id);
    List<ContactsDetailsData> findByPepId(@Param("pepId") Integer pepId);
    //List<AkaDetData> findByPepId(@Param("pepId") Integer pepId);
}
