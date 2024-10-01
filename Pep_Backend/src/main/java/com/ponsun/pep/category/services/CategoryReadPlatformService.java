package com.ponsun.pep.category.services;

import com.ponsun.pep.category.domain.Category;

import java.util.List;

public interface CategoryReadPlatformService {
    Category fetchCategoryById(Integer id);

    List<Category> fetchAllCategory();
}
