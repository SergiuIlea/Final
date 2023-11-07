package org.fasttrack.ui;

import org.fasttrack.model.Order;
import org.fasttrack.model.Product;
import org.fasttrack.service.OrderService;
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
    private OrderService orderService;

    @Autowired
    public AppController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("manager-product-app")
    String getAllProductsForManager(Model model){
        List<Product> productsFromDB = productService.getAllProducts();
        model.addAttribute("products", productsFromDB);
        return "manager-product-app";
    }

    @GetMapping("manager-order-app")
    String getAllOrdersForManager(Model model){
        List<Order> ordersFromDB = orderService.getAllOrders();
        model.addAttribute("orders", ordersFromDB);
        return "manager-order-app";
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
        model.addAttribute("orderUser", allProducts.get(0).getOrder().getUser());
        return "order-product-app";
    }

    @GetMapping("SIV3D")
    String getWelcomePage(){
        return "SIV3D";
    }
}
