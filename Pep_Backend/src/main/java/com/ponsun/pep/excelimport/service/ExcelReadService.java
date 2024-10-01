package com.ponsun.pep.excelimport.service;

import com.ponsun.pep.EhcachePOC.Data.OFACData;
import com.ponsun.pep.dto.ScreenDTO;
import com.ponsun.pep.dto.SearchDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ExcelReadService {

    void calculateScore(List<SearchDTO> searchDTO,List<OFACData> ofacdataList) throws ExecutionException, InterruptedException;
    void calculateScores(List<ScreenDTO> screenDTO, List<OFACData> ofacdataList) throws ExecutionException, InterruptedException;
}
