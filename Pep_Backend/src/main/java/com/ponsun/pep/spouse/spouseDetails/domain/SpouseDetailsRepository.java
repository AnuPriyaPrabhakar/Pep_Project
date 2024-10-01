package com.ponsun.pep.spouse.spouseDetails.domain;

import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.spouse.spouseDetails.data.SpouseDetailsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpouseDetailsRepository extends JpaRepository<SpouseDetails,Integer> {
    Optional<SpouseDetails> findById(Integer id);
    List<SpouseDetailsData> findByPepId(@Param("pepId") Integer pepId);
}