package com.ponsun.pep.pepDetails.Customer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findById(Integer id);
    boolean existsByPan( String pan);
}
