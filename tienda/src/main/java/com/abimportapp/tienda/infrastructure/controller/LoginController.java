package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.LoginService;
import com.abimportapp.tienda.domain.Usuario;
import com.abimportapp.tienda.infrastructure.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login() {
        return "login";
    }
    @GetMapping("/access")
    public String access(HttpSession session) {
        Usuario user =loginService.getIdUser(Integer.parseInt(session.getAttribute("userId").toString()));
        if (loginService.existsUser(user.getEmail())) {
            if (loginService.getUserType(user.getEmail()).name().equals("ADMIN")) {
                return "redirect:/admin";
            }else {
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }
}
