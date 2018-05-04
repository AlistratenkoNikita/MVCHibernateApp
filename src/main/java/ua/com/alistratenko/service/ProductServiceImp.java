package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.dao.ProductDao;
import ua.com.alistratenko.entity.Product;

import java.util.List;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void createNewProduct(Product product) {
        productDao.createProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.listProducts();
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    @Override
    public Product getProductByName(String name) {
        return productDao.getProductByName(name);
    }

    @Override
    public Product getProductByVendorCode(String vendorName) {
        return productDao.getProductByVendorCode(vendorName);
    }

    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }
}
