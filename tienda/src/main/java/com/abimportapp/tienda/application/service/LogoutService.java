package com.abimportapp.tienda.application.service;

import jakarta.servlet.http.HttpSession;

public class LogoutService {
    public LogoutService() {
    }
    public void logout(HttpSession session) {
        session.removeAttribute("userId");
    }
}
