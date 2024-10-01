package com.ponsun.pep.imageDet.services;

import com.ponsun.pep.imageDet.domain.ImageDet;
import com.ponsun.pep.imageDet.domain.ImageDetRepository;
import com.ponsun.pep.imageDet.domain.ImageDetRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageDetReadPlatformServiceImpl implements ImageDetReadPlatformService {

    private final ImageDetRepositoryWrapper imageDetRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ImageDetRepository imageDetRepository;

    @Override
    public ImageDet fetchImageDetById(Integer id){

        return this.imageDetRepository.findById(id).get();

    }
    @Override
    public List<ImageDet> fetchAllImageDet(){
        return this.imageDetRepository.findAll();
    }

}
