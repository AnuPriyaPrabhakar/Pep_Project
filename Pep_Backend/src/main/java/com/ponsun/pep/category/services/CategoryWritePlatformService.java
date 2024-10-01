package com.ponsun.pep.category.services;

import com.ponsun.pep.category.request.CreateCategoryRequest;
import com.ponsun.pep.category.request.UpdateCategoryRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface CategoryWritePlatformService {
    Response createCategory(CreateCategoryRequest createCategoryRequest);
    Response updateCategory(Integer id, UpdateCategoryRequest updateCategoryRequest);
    Response blockCategory(Integer id);
    Response unblockCategory(Integer id);
}
