package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.LoginForm;
import com.example.thuggeelya.data.security.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginFormService service;

    @Autowired
    public LoginController(LoginFormService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public @ResponseBody
    LoginForm getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            return null;
        }

        Object principal = auth.getPrincipal();
        LoginForm loginForm = (principal instanceof LoginForm) ? (LoginForm) principal : null;
        System.out.println(loginForm);
        return Objects.nonNull(loginForm) ? this.service.getByLogin(loginForm.getLogin()) : null;
    }
}
