package com.abimportapp.tienda.infrastructure.service;

import com.abimportapp.tienda.application.service.LoginService;
import com.abimportapp.tienda.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final LoginService loginService;
    private final Integer USER_NOT_FOUND = 0;
    @Autowired
    private HttpSession session;

    public UserDetailServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer idUser = loginService.getUserId(username);
        if (idUser != USER_NOT_FOUND) {
            Usuario user = loginService.getUser(username);
            session.setAttribute("userId",user.getId());
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getUserType().name())
                    .build();
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
