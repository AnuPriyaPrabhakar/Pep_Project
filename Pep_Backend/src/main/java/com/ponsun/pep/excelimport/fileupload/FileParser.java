package com.ponsun.pep.excelimport.fileupload;

import java.util.List;
import java.util.Map;

public interface FileParser {
    List<Map<String, Object>> parseExcelData();
}
