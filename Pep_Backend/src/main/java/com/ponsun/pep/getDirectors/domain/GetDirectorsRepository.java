package com.ponsun.pep.getDirectors.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface GetDirectorsRepository extends JpaRepository<GetDirectors,Integer> {
    Optional<GetDirectors> findById(Integer id);
}
