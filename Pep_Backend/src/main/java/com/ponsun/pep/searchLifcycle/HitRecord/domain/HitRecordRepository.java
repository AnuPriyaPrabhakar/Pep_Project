package com.ponsun.pep.searchLifcycle.HitRecord.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HitRecordRepository extends JpaRepository<HitRecord,Integer> {
    Optional<HitRecord> findById(Integer id);

    @Query("SELECT h FROM HitRecord h WHERE h.criminalId = :criminalId AND h.searchId = :searchId")
    Optional<HitRecord> findHitId(Integer criminalId,Integer searchId);

    @Modifying
    @Query("UPDATE HitRecord a SET a.valid = :valid WHERE a.id = :hitId")
    default void updateValidityById(boolean valid,Integer hitId){

    }
}
