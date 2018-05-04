package ua.com.alistratenko.dao;

import ua.com.alistratenko.entity.Product;

import java.util.List;

public interface ProductDao {

    void createProduct(Product product);

    List<Product> listProducts();

    void updateProduct(Product product);

    void deleteProduct(Product product);

    Product getProductByName(String name);

    Product getProductByVendorCode(String vendorName);

    Product getProductById(String id);
}
