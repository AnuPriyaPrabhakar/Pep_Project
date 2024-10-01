package com.ponsun.pep.category.api;


import com.ponsun.pep.category.domain.Category;
import com.ponsun.pep.category.request.CreateCategoryRequest;
import com.ponsun.pep.category.request.UpdateCategoryRequest;
import com.ponsun.pep.category.services.CategoryReadPlatformService;
import com.ponsun.pep.category.services.CategoryWritePlatformService;
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
@RequestMapping("/api/v1/Category")
@Tag(name = "CategoryApiResource")
public class CategoryApiResource {
    private final CategoryWritePlatformService categoryWritePlatformService;
    private final CategoryReadPlatformService categoryReadPlatformService;

    @PostMapping("/CreateCategoryRequest")
    public Response saveCategory(@RequestBody CreateCategoryRequest createCategoryRequest) {
        log.debug("START saveCategory request body {}",createCategoryRequest);
        Response response = this.categoryWritePlatformService.createCategory(createCategoryRequest);
        log.debug("START saveCategory response",response);
        return response;
    }

    @GetMapping
    public List<Category> fetchAll() {
        return this.categoryReadPlatformService.fetchAllCategory();
    }

    @GetMapping("/{id}")
    public Category fetchCategoryById(@PathVariable(name = "id") Integer id) {
        return this.categoryReadPlatformService.fetchCategoryById(id);
    }
    @PutMapping("/{id}")
    public Response updateCategory(@PathVariable Integer id, @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        log.debug("START updateCategory request body {}",updateCategoryRequest);
        Response response = this.categoryWritePlatformService.updateCategory(id, updateCategoryRequest);
        log.debug("START updateCategory response",response);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockCategory(@PathVariable Integer id){
        Response response = this.categoryWritePlatformService.blockCategory(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockCategory(@PathVariable Integer id){
        Response response = this.categoryWritePlatformService.unblockCategory(id);
        return response;
    }


}
