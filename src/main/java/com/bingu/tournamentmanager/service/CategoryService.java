package com.bingu.tournamentmanager.service;


import com.bingu.tournamentmanager.model.Category;

import java.util.Collection;

public interface CategoryService {

    public Category saveCategory(Category category);
    public void deleteCategory(String category);
    public Category findCategoryByCategoryname(String category);
    public Collection<Category> findAll();
}
