package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.LogoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/close")
public class LogoutController {
    private final LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }
    @GetMapping
    public String logout(HttpSession session) {
        logoutService.logout(session);
        return "redirect:/home";
    }
}
