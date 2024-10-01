package com.ponsun.pep.category.domain;

import com.ponsun.pep.category.request.AbstractCategoryRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryRepositoryWrapper extends AbstractCategoryRequest {
    private final CategoryRepository categoryRepository;
    @Transactional
    public Category findOneWithNotFoundDetection(final Integer id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
