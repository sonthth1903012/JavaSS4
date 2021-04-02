package t1907m.springboot_crud_product_user.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "pro_name")
    private String pro_name;

    @Column(name = "pro_desc")
    private String pro_desc;

    @Column(name = "image")
    private String image;

    public Product() {
    }


    public Product(@NotEmpty(message = "The product name cannot be left blank") String pro_name, @NotEmpty(message = "The product description cannot be left blank") String pro_desc, String image) {
        this.pro_name = pro_name;
        this.pro_desc = pro_desc;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    public String getImage() {
        if (image == null )return null;
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
