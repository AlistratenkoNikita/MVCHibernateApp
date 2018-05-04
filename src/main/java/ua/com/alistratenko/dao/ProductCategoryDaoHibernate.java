package ua.com.alistratenko.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.alistratenko.entity.ProductCategory;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductCategoryDaoHibernate implements ProductCategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProductCategory(ProductCategory productCategory) {
        sessionFactory.getCurrentSession().save(productCategory);
    }

    @Override
    public List<ProductCategory> listProductCategorys() {
        Query query = sessionFactory.getCurrentSession().createQuery("from ProductCategory");
        List list = query.list();

        return Collections.checkedList(list, ProductCategory.class);
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {
        sessionFactory.getCurrentSession().update(productCategory);
    }

    @Override
    public void deleteProductCategory(ProductCategory productCategory) {
        sessionFactory.getCurrentSession().delete(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ProductCategory where name = :name");
        query.setParameter("name", name);

        return (ProductCategory) query.uniqueResult();
    }
}
