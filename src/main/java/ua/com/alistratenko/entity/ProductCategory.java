package ua.com.alistratenko.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private ProductCategory parentCategory;

    @NotNull
    @Length(max = 45)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(max = 200)
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "parentCategory")
    private List<ProductCategory> subCategories;

    public ProductCategory() {
        subCategories = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public ProductCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductCategory getParentCategory() {
        return parentCategory;
    }

    public ProductCategory setParentCategory(ProductCategory parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductCategory setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategory setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<ProductCategory> getSubCategories() {
        return subCategories;
    }

    public ProductCategory setSubCategories(List<ProductCategory> subCategories) {
        this.subCategories = subCategories;
        return this;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", parentCategory=" + parentCategory +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subCategories=" + subCategories.size() +
                '}';
    }
}
