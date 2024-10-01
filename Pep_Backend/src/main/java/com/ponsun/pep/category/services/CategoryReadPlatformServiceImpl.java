package com.ponsun.pep.category.services;

import com.ponsun.pep.category.domain.Category;
import com.ponsun.pep.category.domain.CategoryRepository;
import com.ponsun.pep.category.domain.CategoryRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryReadPlatformServiceImpl implements CategoryReadPlatformService{
    private final CategoryRepositoryWrapper categoryRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CategoryRepository categoryRepository;

    @Override
    public Category fetchCategoryById(Integer id){

        return this.categoryRepository.findById(id).get();

    }
    @Override
    public List<Category> fetchAllCategory(){
        return this.categoryRepository.findAll();
    }
}
