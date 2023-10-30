package org.fasttrack.ui;

import org.fasttrack.model.Product;
import org.fasttrack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {
    private ProductService productService;

    @Autowired
    public AppController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("manager-product-app")
    String getAllProductsForManager(Model model){
        List<Product> productsFromDB = productService.getAllProducts();
        model.addAttribute("products", productsFromDB);
        return "manager-product-app";
    }

    @GetMapping("customer-app")
    String getAllProductsForCustomer(Model model){
        List<Product> productsFromDB = productService.getAllProducts();
        model.addAttribute("products", productsFromDB);
        return "customer-app";
    }

    @GetMapping("SIV3D")
    String getWelcomePage(){
        return "SIV3D";
    }
}
