package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.*;
import com.abimportapp.tienda.domain.*;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/order")
@Slf4j
public class OrderController {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final StockService stockService;
    private final ValidateStock validateStock;
    private final Integer UNIT_IN = 0;

    public OrderController(CartService cartService, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model ,HttpSession session) {
        log.info("userId desde la variable de sesion: {}", session.getAttribute("userId").toString());
        Usuario user = userService.findById(Integer.parseInt(session.getAttribute("userId").toString()));
        model.addAttribute("cart", cartService.getListItems());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        model.addAttribute("id",session.getAttribute("userId").toString());
        return "user/sumaryorder";
    }
    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes, HttpSession session) {
        log.info("Creating order...");
        log.info("userId desde la variable de sesion: {}", session.getAttribute("userId").toString());
        Usuario user = userService.findById(Integer.parseInt(session.getAttribute("userId").toString()));
        Order order = new Order();
        order.setDateCreated(LocalDateTime.now());
        order.setUser(user);
        order = orderService.createOrder(order);
        List<OrderProduct> orderProducts = new ArrayList<>();
        for(ItemCart itemCart : cartService.getListItems()){
            orderProducts.add(new OrderProduct(productService.getProductById(itemCart.getIdProduct()), itemCart.getQuantity(), order));
        }
        //Guardar los productos de la orden
        orderProducts.forEach(
                op ->{
                    orderProductService.create(op);
                    Stock stock = new Stock();
                    stock.setDateCreated(LocalDateTime.now());
                    stock.setProduct(op.getProduct());
                    stock.setDescription("venta");
                    stock.setUnitIn(UNIT_IN);
                    stock.setUnitOut(op.getQuantity());
                    stockService.saveStock(validateStock.calcularBalance(stock));
                }
        );
        cartService.removeAllItemsCart();
        attributes.addFlashAttribute("id",session.getAttribute("userId").toString());
        return "redirect:/home";
    }
}
