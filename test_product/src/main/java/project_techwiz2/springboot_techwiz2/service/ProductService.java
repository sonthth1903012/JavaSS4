package project_techwiz2.springboot_techwiz2.service;

import project_techwiz2.springboot_techwiz2.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();

    Product getProById(int pro_id);

    boolean saveProduct(Product product);

    boolean deleteProduct(int pro_id);

    boolean updateProduct(Product product);

}
