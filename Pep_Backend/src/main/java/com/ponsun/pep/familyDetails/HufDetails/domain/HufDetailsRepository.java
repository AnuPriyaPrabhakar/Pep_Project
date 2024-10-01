package com.ponsun.pep.familyDetails.HufDetails.domain;



import com.ponsun.pep.familyDetails.HufDetails.data.HufDetailsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HufDetailsRepository extends JpaRepository<HufDetails,Integer> {
    Optional<HufDetails> findById(Integer id);
    List<HufDetailsData> findByPepId(@Param("pepId") Integer pepId);
}