package com.ponsun.pep.imageDet.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.imageDet.request.CreateImageDetRequest;
import com.ponsun.pep.imageDet.request.UpdateImageDetRequest;

public interface ImageDetWritePlatformService {
    Response createImageDet(CreateImageDetRequest createImageDetRequest);
    Response updateImageDet(Integer id, UpdateImageDetRequest updateImageDetRequest);
    Response blockImageDet(Integer id);
    Response unblockImageDet(Integer id);

}
