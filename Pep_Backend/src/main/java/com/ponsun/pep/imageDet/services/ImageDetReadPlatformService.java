package com.ponsun.pep.imageDet.services;

import com.ponsun.pep.imageDet.domain.ImageDet;
import java.util.List;

public interface ImageDetReadPlatformService {
    ImageDet fetchImageDetById(Integer id);
    List<ImageDet> fetchAllImageDet();
}
