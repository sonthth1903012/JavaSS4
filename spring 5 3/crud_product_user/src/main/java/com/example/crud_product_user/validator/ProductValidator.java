package t1907m.springboot_crud_product_user.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import t1907m.springboot_crud_product_user.model.User;
import t1907m.springboot_crud_product_user.service.ProductService;
import t1907m.springboot_crud_product_user.model.Product;

@Component
public class ProductValidator implements Validator {
    @Autowired
    private ProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product pro = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pro_name","NotEmpty.pro.pro_name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pro_desc","NotEmpty.pro.pro_desc");

    }
}
