package com.ponsun.pep.pepDetails.AkaDet.services;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDet;
import java.util.List;

public interface AkaDetReadPlatformService {
    AkaDet fetchAkaDetById(Integer id);
    List<AkaDet> fetchAllAkaDet();
    List<AkaDetData> findBycustomePepId(Integer pepId);
}
