package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.Category;
import com.bingu.tournamentmanager.repository.CategoryRepository;
import com.bingu.tournamentmanager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String category) {
        categoryRepository.deleteById(category);
    }

    @Override
    public Category findCategoryByCategoryname(String category) {
        return categoryRepository.findById(category).orElse(null);
    }

    @Override
    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }
}
