package com.ponsun.pep.nameSearch.Count.service;

import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.dto.SearchDTO;

import java.util.List;

public interface CountReadService {

    List<RecordDTO>  getRecordsCount(SearchDTO searchDTO);
}
