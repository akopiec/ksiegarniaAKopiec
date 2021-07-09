package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.dao.CategoryDAO;
import pl.umcs.entity.Category;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDAO categoryDAO;
    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO)
    {
        this.categoryDAO = categoryDAO;
    }
    @Override
    @Transactional
    public List<Category> getCategories()
    {
        return categoryDAO.getCategories();
    }
    @Override
    @Transactional
    public void saveCategory(Category category)
    {
        categoryDAO.saveCategory(category);
    }
    @Override
    @Transactional
    public Category getCategory(int categoryId)
    {
        return categoryDAO.getCategory(categoryId);
    }
    @Override
    @Transactional
    public void deleteCategory(int categoryId)
    {
        categoryDAO.deleteCategory(categoryId);
    }
}

