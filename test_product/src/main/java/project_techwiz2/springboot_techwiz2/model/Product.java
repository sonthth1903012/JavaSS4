package project_techwiz2.springboot_techwiz2.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    @NotEmpty(message = "Please insert product name!")
    @Size(min = 3,max = 30)
    private String product_name;
    @DecimalMin(value = "0.000000000000000000001",message = "Price must be higher than 0!")
    private double price;

    @NotEmpty(message = "Please insert description!")
    private String description;


    public Product() {
    }

    public Product(String product_name, double price, String descriptions) {
        this.product_name = product_name;
        this.price = price;
        this.description = descriptions;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescriptions() {
        return description;
    }

    public void setDescriptions(String descriptions) {
        this.description = descriptions;
    }




}
