package t1907m.springboot_crud_product_user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1907m.springboot_crud_product_user.repository.ProductRepository;
import t1907m.springboot_crud_product_user.service.ProductService;
import t1907m.springboot_crud_product_user.model.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean insertPro(Product p) {
        try{
            productRepository.save(p);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProduct() {
            List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public Product getProById(int id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public boolean updatePro(Product p) {
        try{
            productRepository.save(p);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePro(int id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> searchProByName(String key) {
        List<Product> list = productRepository.searchByname(key);
        return list;
    }
}
