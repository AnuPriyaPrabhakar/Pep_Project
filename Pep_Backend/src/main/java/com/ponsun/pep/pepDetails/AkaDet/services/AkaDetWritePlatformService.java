package com.ponsun.pep.pepDetails.AkaDet.services;

import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.request.UpdateAkaDetRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface AkaDetWritePlatformService {
    Response createAkaDet(CreateAkaDetRequest createAkaDetRequest);
    Response updateAkaDet(Integer id, UpdateAkaDetRequest updateAkaDetRequest);
    Response blockAkaDet(Integer id);
    Response unblockAkaDet(Integer id);
    Response deactive(Integer pepId, Integer euid);
}
