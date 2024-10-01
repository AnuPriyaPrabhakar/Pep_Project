
package com.ponsun.pep.pepDetails.Pan.services;


import com.ponsun.pep.pepDetails.Pan.data.PanData;

import java.util.List;

public interface PanWritePlatformService {
    List<PanData> getPan( String pan);
}
