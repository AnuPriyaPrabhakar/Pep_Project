package com.ponsun.pep.excelimport.controller;

import com.ponsun.pep.dto.ScreenDTO;
import com.ponsun.pep.excelimport.fileupload.XlsFileParser;
import com.ponsun.pep.excelimport.service.ExcelDataCommandService;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/excel")
@RequiredArgsConstructor
@Slf4j
public class ExcelDataController {

    private final ExcelDataCommandService excelDataCommandService;

    @PostMapping("/tableBulkImport")
    public Response saveExcelDataFromFile() {
        log.debug("START of saveExcelDataFromFile() ");
        XlsFileParser xlsFileParser = new XlsFileParser("D:\\workspace\\file_upload", "excel_data.xlsx");
        final List<Map<String, Object>> data = xlsFileParser.parseExcelData();
        Response response = excelDataCommandService.saveBulkData(data);
        log.debug("END of saveExcelDataFromFile()");
        return response;
    }

    @PostMapping("/saveScreeningData")
    public ResponseEntity<Response> saveKycScreeningData(@RequestBody List<ScreenDTO> screenDTOList) {
        Response response = excelDataCommandService.saveKycScreeningData(screenDTOList);
        return ResponseEntity.ok(response);
    }
}























