package ua.com.alistratenko.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @NotNull
    @Length(max = 45)
    @Column(name = "vendor_code")
    private String vendorCode;

    @NotNull
    @Length(max = 100)
    @Column(name = "name")
    private String name;

    @Min(0)
    @NotNull
    @Column(name = "price")
    private Float price;

    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public Product() {
        orderItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Product setCategory(ProductCategory category) {
        this.category = category;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public Product setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Product setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Product setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Product setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", vendorCode='" + vendorCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", orderItems='" + orderItems.size() + '\'' +
                '}';
    }
}
