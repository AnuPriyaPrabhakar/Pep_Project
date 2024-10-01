package com.ponsun.pep.category.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findById(Integer id);

}
