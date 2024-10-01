package com.ponsun.pep.listOfCompany.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListOfCompanyRepository extends JpaRepository<ListOfCompany,Integer> {
    Optional<ListOfCompany> findById(Integer id);
}
