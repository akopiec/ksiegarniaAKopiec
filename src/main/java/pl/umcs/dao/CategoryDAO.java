package pl.umcs.dao;

import pl.umcs.entity.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getCategories();

    Category getCategory(int categoryId);
    void deleteCategory(int categoryID);
    void saveCategory(Category category);

}
