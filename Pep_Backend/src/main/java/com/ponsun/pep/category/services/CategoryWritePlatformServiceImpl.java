package com.ponsun.pep.category.services;

import com.ponsun.pep.category.data.CategoryDataValidator;
import com.ponsun.pep.category.domain.Category;
import com.ponsun.pep.category.domain.CategoryRepository;
import com.ponsun.pep.category.domain.CategoryRepositoryWrapper;
import com.ponsun.pep.category.request.CreateCategoryRequest;
import com.ponsun.pep.category.request.UpdateCategoryRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryWritePlatformServiceImpl implements CategoryWritePlatformService{
    private final CategoryRepository categoryRepository;
    private final CategoryRepositoryWrapper categoryRepositoryWrapper;
    private final CategoryDataValidator categoryDataValidator;


    @Transactional
    public Response createCategory(CreateCategoryRequest createCategoryRequest) {
        try {
            this.categoryDataValidator.validateSaveCategory(createCategoryRequest);
            final Category category = Category.create(createCategoryRequest);
            this.categoryRepository.saveAndFlush(category);
            return Response.of(Long.valueOf(category.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCategory(Integer id, UpdateCategoryRequest updateCategoryRequest) {
        try {
            this.categoryDataValidator.validateUpdateCategory(updateCategoryRequest);
            final Category category = this.categoryRepositoryWrapper.findOneWithNotFoundDetection(id);
            category.update(updateCategoryRequest);
            this.categoryRepository.saveAndFlush(category);
            return Response.of(Long.valueOf(category.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public  Response blockCategory(Integer id){
        try {
            final Category category = this.categoryRepositoryWrapper.findOneWithNotFoundDetection(id);
            category.setStatus(Status.DELETE);
            category.setUpdatedAt(LocalDateTime.now());
            this.categoryRepository.saveAndFlush(category);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockCategory(Integer id){
        try {
            final Category category = this.categoryRepositoryWrapper.findOneWithNotFoundDetection(id);
            category.setStatus(Status.ACTIVE);
            category.setUpdatedAt(LocalDateTime.now());
            this.categoryRepository.saveAndFlush(category);
            return Response.of(Long.valueOf(id));
        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
