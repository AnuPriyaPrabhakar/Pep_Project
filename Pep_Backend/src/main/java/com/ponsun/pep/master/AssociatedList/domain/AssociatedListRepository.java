package com.ponsun.pep.master.AssociatedList.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AssociatedListRepository extends JpaRepository<AssociatedList,Integer> {
    Optional<AssociatedList> findById(Integer id);
}
