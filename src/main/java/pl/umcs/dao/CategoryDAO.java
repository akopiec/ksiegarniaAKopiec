package pl.umcs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.umcs.entity.Category;

import java.util.List;
@Repository
public class CategoryDAO {

    private  SessionFactory sessionFactory;

    @Autowired
    public CategoryDAO(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public List<Category> getCategories() {

        return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).getResultList();
    }

    public void saveCategory(Category category) {

        sessionFactory.getCurrentSession().save(category);
    }

    public Category getCategory(int categoryId) {

        return sessionFactory.getCurrentSession().get(Category.class, categoryId);
    }

    public void deleteCategory(int categoryId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("DELETE FROM Category WHERE id = :id");

        query.setParameter("id", categoryId);

        query.executeUpdate();
    }
}

