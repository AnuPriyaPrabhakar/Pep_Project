package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.api;

import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data.AssociatedCompaniesData;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.CreateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.UpdateAssociatedCompaniesRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services.AssociatedCompaniesReadPlatformService;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.services.AssociatedCompaniesWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.service.CompanyCompainedReadService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AssociatedCompanies")
@Tag(name ="AssociatedCompaniesApiResource")
public class AssociatedCompaniesApiResource {

    private final AssociatedCompaniesWritePlatformService associatedCompaniesWritePlatformService;
    private final AssociatedCompaniesReadPlatformService associatedCompaniesReadPlatformService;
    private final CompanyCompainedReadService companyCompainedReadService;
    @PostMapping("/CreateAssociatedCompaniesRequest")
    public Response saveAssociatedCompanies(@RequestBody CreateAssociatedCompaniesRequest createAssociatedCompaniesRequest){
        log.debug("START saveAssociatedCompanies request body {}",createAssociatedCompaniesRequest);
        Response response = this.associatedCompaniesWritePlatformService.createAssociatedCompanies(createAssociatedCompaniesRequest);
        log.debug("START saveAssociatedCompanies response",response);
        return response;
    }
    @GetMapping
    public List<AssociatedCompanies> fetchAll(){return this.associatedCompaniesReadPlatformService.fetchAllAssociatedCompanies();}
    @GetMapping("/{id}")
    public AssociatedCompanies fetchAllAssociatedCompaniesById(@PathVariable(name = "id")Integer id){
        return this.associatedCompaniesReadPlatformService.fetchAssociatedCompaniesById(id);

    }
    @PutMapping("/{id}")
    public Response updateAssociatedCompaines(@PathVariable Integer id, @RequestBody UpdateAssociatedCompaniesRequest updateAssociatedCompaniesRequest){
        log.debug("START updateAssociatedCompaines request body {}",updateAssociatedCompaniesRequest);
        Response response = this.associatedCompaniesWritePlatformService.updateAssociatedCompanies(id,updateAssociatedCompaniesRequest);
        log.debug("START updateAssociatedCompaines response",response);
        return response;
    }
    @DeleteMapping("/{id}")
    public Response deleteAssociatedCompaines(@PathVariable(name = "id")Integer id){
        Response response= this.associatedCompaniesWritePlatformService.deleteAssociatedCompanies(id);
        return response;
    }
    @PostMapping("/insertAssociatedCompanies")
    public Integer insertAssociatedCompanies(String companyName,String CINFCRN,String originalDateOfAppointment , Integer associateMasterId,String sourceLink,Integer typeId,Integer listAdverseInformation,Integer listRegulatoryAction,Integer listGovernment){
        Integer response = this.associatedCompaniesWritePlatformService.insertAssociatedCompanies(companyName,CINFCRN,associateMasterId,originalDateOfAppointment ,sourceLink, typeId, listAdverseInformation, listRegulatoryAction, listGovernment);
        return response;
    }
    @GetMapping("/din")
    public List<AssociatedCompaniesData> fetchAssociatedCompaniesData(String din){
        return this.associatedCompaniesWritePlatformService.fetchAssociatedCompaniesData(din);

    }

        @PutMapping("/{id}/deActivate")
        public Response deActivate(@RequestParam Integer id, @RequestParam Integer euid){
            Response response = this.associatedCompaniesWritePlatformService.deactive(id,euid);
            return response;
        }
}