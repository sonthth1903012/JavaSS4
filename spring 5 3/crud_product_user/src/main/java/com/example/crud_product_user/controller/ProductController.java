package t1907m.springboot_crud_product_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import t1907m.springboot_crud_product_user.service.ProductService;
import t1907m.springboot_crud_product_user.model.Product;
import t1907m.springboot_crud_product_user.validator.ProductValidator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductValidator productValidator;

    @RequestMapping(value = "")
    public String listProduct(Model model) {
        List<Product> list = productService.getAllProduct();
        model.addAttribute("list", list);
        return "product/listPro";
    }

    @RequestMapping(value = "/create")
    public String insertPro(Model model) {
        Product pro = new Product();
        model.addAttribute("pro", pro);
        return "product/insertPro";
    }

    @RequestMapping(value = "/savePro", method = RequestMethod.POST)
    public String savePro(@ModelAttribute("pro") Product pro, @RequestParam("uploadingfile") MultipartFile uploadFiles, BindingResult result, Model model) throws IOException {
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        productValidator.validate(pro, result);
        if (result.hasErrors()) {
            model.addAttribute("pro", pro);
            return "product/insertPro";
        } else {
            File file = new File(uploadingDir + randomWithNextInt + uploadFiles.getOriginalFilename());
            uploadFiles.transferTo(file);
            pro.setImage("/uploadingDir/" + randomWithNextInt + uploadFiles.getOriginalFilename());
            productService.insertPro(pro);
            return "redirect:/product?success";
        }
    }

    @RequestMapping(value = "/edit")
    public String editPro(@RequestParam("id") Integer id, Model model) {
        Product product = productService.getProById(id);
        model.addAttribute("pro", product);
        return "product/editPro";
    }

    @RequestMapping(value = "/updatePro", method = RequestMethod.POST)
    public String updatePro(@ModelAttribute("pro") Product pro, Model model, @RequestParam("uploadingfile") MultipartFile uploadFiles) throws IOException {
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        String filename = uploadFiles.getOriginalFilename();

        if (!filename.isEmpty()) {
            File file = new File(uploadingDir + randomWithNextInt + uploadFiles.getOriginalFilename());
            uploadFiles.transferTo(file);

            pro.setImage("/uploadingDir/" + randomWithNextInt + uploadFiles.getOriginalFilename());
        } else {
            Product p = productService.getProById(pro.getId());
            pro.setImage(p.getImage());
        }


        boolean p = productService.updatePro(pro);
        if (p) {
            return "redirect:/product?success";
        } else {
            model.addAttribute("pro", pro);
            return "product/editPro?error";

        }

    }

    @RequestMapping(value = "/deletePro")
    public String deletePro(@RequestParam("id") Integer id, Model model) {
        boolean b = productService.deletePro(id);
        if (b) {
            return "redirect:/product?success";
        } else {
            return "redirect:/product?error";
        }
    }


    @RequestMapping(value = "/searchPro")
    public String getProByName(@RequestParam("keyword") String key, Model model) {
        List<Product> list = productService.searchProByName(key);
        model.addAttribute("list", list);
        return "product/listPro";
    }
}
