package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginFormService service;
    private final UserRepository userRepository;

    @Autowired
    public LoginController(LoginFormService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public @ResponseBody
    Map<LoginForm, Boolean> getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            return null;
        }

        Object principal = auth.getPrincipal();
        LoginForm loginForm = (principal instanceof LoginForm) ? (LoginForm) principal : null;
        System.out.println(loginForm);

        if (Objects.nonNull(loginForm)) {
            LoginForm loginForm1 = this.service.getByLogin(loginForm.getLogin());
            User user = userRepository.findByIduser(loginForm1.getIduser()).orElse(null);

            if (Objects.nonNull(user)) {
                for (Role role : user.getRoles()) {
                    if (role.getIdrole().equals(RoleEnum.ROLE_ADMIN.getId())) {
                        return new HashMap<LoginForm, Boolean>() {
                            {
                                put(service.getByLogin(loginForm.getLogin()), true);
                            }
                        };
                    }
                }
            }

            return new HashMap<LoginForm, Boolean>() {{
                put(service.getByLogin(loginForm.getLogin()), false);
            }};
        }

        return new HashMap<LoginForm, Boolean>() {{
            put(null, false);
        }};
    }
}
