package com.ponsun.pep.EhcachePOC.API;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/aOFACCacheApiResources1")
@Tag(name = "OFACCacheApiResources")
public class OFACCacheApiResources {

//    final private  OFACSearchService ofacSearchService;
//    final private OFACDetailService ofacDetailService;
//
//    @GetMapping("/ofacSearchdataAdd")
//    public List<OFACData> fetchAll(){
//        return this.ofacSearchService.fetchAllOFACData();
//    }
//    @GetMapping("/ofacSearchdataDelete")
//    public String deleteAll(){
//        return this.ofacSearchService.deleteOfacData();
//    }
//    @GetMapping("/ofacDetailData")
//    public List<RecordDetailData> fetchTestingData(){
//        return this.ofacDetailService.fetchTestingData();
//    }
//    @GetMapping("/ofacDetailDataById")
//    public List<RecordDetailData> fetchTestingDataById(Integer id){
//        return this.ofacDetailService.fetchTestingDataById(id);
//    }
}
