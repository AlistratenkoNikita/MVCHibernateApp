package ua.com.alistratenko.dao;

import ua.com.alistratenko.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    void createProductCategory(ProductCategory ProductCategory);

    List<ProductCategory> listProductCategorys();

    void updateProductCategory(ProductCategory ProductCategory);

    void deleteProductCategory(ProductCategory ProductCategoryCategory);

    ProductCategory getProductCategoryByName(String name);
}
