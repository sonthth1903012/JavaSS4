package project_techwiz2.springboot_techwiz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.Product;
import project_techwiz2.springboot_techwiz2.service.ProductService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(path = "/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping("")
    public String getProducts(Model model)
    {
        return "/admin/product/productList";
    }


    @RequestMapping("/admin/insertProduct")
    public String insertPro(Model model)
    {
        Product product = new Product();
        model.addAttribute("proNew",product);
        return "/admin/product/insertProduct";
    }

    @RequestMapping(value = "/admin/savePro",method = RequestMethod.POST)
    public String savePro(@ModelAttribute("proNew")@Valid Product product, BindingResult result,Model model)throws IOException
    {
        if (result.hasErrors())
        {
            model.addAttribute("proNew",product);
            return "/admin/product/insertProduct";
        }

        boolean bl = productService.saveProduct(product);
        if(bl)
        {
            return "redirect:/admin/product?success=Add New product success";
        }
        return "redirect:/admin/product?error=Add New product error";
    }

    @RequestMapping(value = "/admin/editPro")
    public String editPro(@RequestParam("id")Integer id,Model model)
    {
        Product product = productService.getProById(id);
        model.addAttribute("proEdit",product);
        return "/admin/product/editProduct";
    }

    @RequestMapping(value = "/admin/updatePro",method = RequestMethod.POST)
    public String updatePro(@ModelAttribute("proEdit")Product product,Model model)throws IOException
    {
        boolean bl = productService.updateProduct(product);
        if (bl)
        {
            return "redirect:/admin/product?success=Add New product success";
        }
        return "redirect:/admin/product?error=Add New product error";
    }

    @RequestMapping(value = "/admin/detailPro")
    public String detailProductById(@RequestParam("id")Integer id,Model model)
    {
        Product product = productService.getProById(id);
        model.addAttribute("proDetail",product);
        return "/admin/product/detailProduct";
    }

    @RequestMapping(value = "/admin/deleteProducts")
    public String deleteProduct(@RequestParam("id")Integer id)
    {
        boolean bl = productService.deleteProduct(id);
        if (bl)
        {
            return "redirect:/admin/product?success=Delete product success";
        }
        return "redirect:/admin/product?error=Delete product error";
    }




}
