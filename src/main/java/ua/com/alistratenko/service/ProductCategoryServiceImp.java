package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.dao.ProductCategoryDao;
import ua.com.alistratenko.entity.ProductCategory;

import java.util.List;

@Service
@Transactional
public class ProductCategoryServiceImp implements ProductCategoryService {

    @Autowired
    ProductCategoryDao productCategoryDao;

    @Override
    public void createNewProductCategory(ProductCategory productCategory) {
        productCategoryDao.createProductCategory(productCategory);
    }

    @Override
    public List<ProductCategory> getAllProductCategorys() {
        return productCategoryDao.listProductCategorys();
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {
        productCategoryDao.updateProductCategory(productCategory);
    }

    @Override
    public void deleteProductCategory(ProductCategory productCategory) {
        productCategoryDao.deleteProductCategory(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return productCategoryDao.getProductCategoryByName(name);
    }
}
