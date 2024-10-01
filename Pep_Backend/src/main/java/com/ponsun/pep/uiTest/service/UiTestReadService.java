package com.ponsun.pep.uiTest.service;

import com.ponsun.pep.uiTest.dto.UiReciveRecord;
import com.ponsun.pep.uiTest.dto.UiRecordDTO;
import com.ponsun.pep.uiTest.dto.UiSearchDTO;
import com.ponsun.pep.uiTest.dto.UiSearchDtoVerify;

import java.util.List;

public interface UiTestReadService {
    List<UiRecordDTO>  getuiTestRecords(UiSearchDTO searchDTO);
    List<UiReciveRecord>  getUiRecords(UiSearchDtoVerify uiSearchDtoVerify);

    String calculateJaroWinklerSimilarity(String str1, String str2);
}
