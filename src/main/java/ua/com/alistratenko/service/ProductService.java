package ua.com.alistratenko.service;


import ua.com.alistratenko.entity.Product;

import java.util.List;

public interface ProductService {

    void createNewProduct(Product product);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct(Product product);

    Product getProductByName(String name);

    Product getProductByVendorCode(String vendorName);

    Product getProductById(String id);
}
