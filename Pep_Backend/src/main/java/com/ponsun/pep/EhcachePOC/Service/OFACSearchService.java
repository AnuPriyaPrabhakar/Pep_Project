package com.ponsun.pep.EhcachePOC.Service;

import com.ponsun.pep.EhcachePOC.Data.OFACData;

import java.util.List;

public interface OFACSearchService {

    List<OFACData> fetchAllOFACData();
    String deleteOfacData();
}
