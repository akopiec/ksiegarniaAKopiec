package pl.umcs.services;

import pl.umcs.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    void saveCategory(Category category);
    Category getCategory(int categoryId);
    void deleteCategory(int categoryId);
}

