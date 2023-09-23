package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.dao.CategoryDAO;
import pl.umcs.entity.Category;

import java.util.List;
@Service
public class CategoryService {

    private final CategoryDAO categoryDAO;
    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {

        this.categoryDAO = categoryDAO;
    }

    @Transactional
    public List<Category> getCategories() {

        return categoryDAO.getCategories();
    }

    @Transactional
    public void saveCategory(Category category) {

        categoryDAO.saveCategory(category);
    }

    @Transactional
    public Category getCategory(int categoryId) {

        return categoryDAO.getCategory(categoryId);
    }

    @Transactional
    public void deleteCategory(int categoryId) {

        categoryDAO.deleteCategory(categoryId);
    }
}

