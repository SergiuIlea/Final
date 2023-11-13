package org.fasttrack.ui;

import org.fasttrack.model.OrderDB;
import org.fasttrack.model.OrderUI;
import org.fasttrack.model.Product;
import org.fasttrack.service.OrderDBService;
import org.fasttrack.service.OrderUIService;
import org.fasttrack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AppController {
    private ProductService productService;
    private OrderDBService orderDBService;
    private OrderUIService orderUIService;

    @Autowired
    public AppController(ProductService productService,
                         OrderDBService orderDBService,
                         OrderUIService orderUIService) {
        this.productService = productService;
        this.orderDBService = orderDBService;
        this.orderUIService = orderUIService;
    }

    @GetMapping("manager-product-app")
    String getAllProductsForManager(Model model){
        List<Product> productsFromDB = productService.getAllProducts();
        model.addAttribute("products", productsFromDB);
        return "manager-product-app";
    }

    @GetMapping("manager-order-DB")
    String getAllOrdersFromDB(Model model){
        List<OrderDB> ordersFromDB = orderDBService.getAllOrdersDB();
        model.addAttribute("ordersDB", ordersFromDB);
        return "manager-order-DB";
    }

    @GetMapping("manager-order-UI")
    String getAllOrdersFromUI(Model model){
        List<OrderUI> ordersFromUI = orderUIService.getAllOrdersUI();
        model.addAttribute("ordersUI", ordersFromUI);
        return "manager-order-UI";
    }

    @GetMapping("customer-app")
    String getAllProductsForCustomer(Model model){
        List<Product> productsFromDB = productService.getAllProducts();
        model.addAttribute("products", productsFromDB);
        return "customer-app";
    }

    @GetMapping("order-product-app/{orderId}")
    String getProductsForOrder(Model model, @PathVariable(required = false) Integer orderId){

        List<Product> allProducts = productService.getProductsByOrderId(orderId);

        model.addAttribute("products", allProducts);
        model.addAttribute("orderUser", allProducts.get(0).getOrderDB().getUsername());
        return "order-product-app";
    }

    @GetMapping("SIV3D")
    String getWelcomePage(){
        return "SIV3D";
    }
}
