package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormService;
import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("/info")
public class MainInfoController {

    private final RestService service;
    private final UserRepository userRepository;
    private final LoginFormService loginFormService;

    @Autowired
    public MainInfoController(RestService service, UserRepository userRepository, LoginFormService loginFormService) {
        this.service = service;
        this.userRepository = userRepository;
        this.loginFormService = loginFormService;
    }

    @GetMapping("/isAdmin")
    public ResponseEntity<?> isCurrentUserAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            return null;
        }

        Object principal = auth.getPrincipal();
        LoginForm loginForm = (principal instanceof LoginForm) ? (LoginForm) principal : null;
        System.out.println(loginForm);

        if (Objects.nonNull(loginForm)) {
            User user = userRepository.findByIduser(this.loginFormService.
                    getByLogin(loginForm.getLogin()).getIduser())
                    .orElse(null);

            if (Objects.nonNull(user)) {
                for (Role role : user.getRoles()) {
                    if (role.getIdrole().equals(RoleEnum.ROLE_ADMIN.getId())) {
                        return ResponseEntity.ok(true);
                    }
                }
            }
        }

        return ResponseEntity.ok(false);
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getAllActivities() {
        return ResponseEntity.ok(service.getActivities());
    }

    @GetMapping("/activities/further")
    public ResponseEntity<?> getFurtherActivities() {
        return ResponseEntity.ok(service.getFurtherActivities());
    }

    @GetMapping("/activities/current")
    public ResponseEntity<?> getCurrentActivities() {
        return ResponseEntity.ok(service.getCurrentActivities());
    }

    @GetMapping("/activities/{id}/participants")
    public ResponseEntity<?>
    getActivityParticipants(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivityParticipantsById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
