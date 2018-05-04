package ua.com.alistratenko.service;

import ua.com.alistratenko.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    void createNewProductCategory(ProductCategory productCategory);

    List<ProductCategory> getAllProductCategorys();

    void updateProductCategory(ProductCategory productCategory);

    void deleteProductCategory(ProductCategory productCategory);

    ProductCategory getProductCategoryByName(String name);
}
