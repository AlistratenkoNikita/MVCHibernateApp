package ua.com.alistratenko.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.alistratenko.entity.Product;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDaoHibernate implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public List<Product> listProducts() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product");
        List list = query.list();

        return Collections.checkedList(list, Product.class);
    }

    @Override
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void deleteProduct(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public Product getProductByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where name = :name");
        query.setParameter("name", name);

        return (Product) query.uniqueResult();
    }

    @Override
    public Product getProductByVendorCode(String vendorCode) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where vendor_code = :vendor_code");
        query.setParameter("vendor_code", vendorCode);

        return (Product) query.uniqueResult();
    }

    @Override
    public Product getProductById(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where id = :id");
        query.setParameter("id", Long.valueOf(id));

        return (Product) query.uniqueResult();
    }
}
