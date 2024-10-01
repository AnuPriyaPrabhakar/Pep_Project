package com.ponsun.pep.imageDet.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ImageDetRepository extends JpaRepository<ImageDet,Integer> {

    Optional<ImageDet> findById(Integer id);

}
