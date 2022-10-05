package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {

    public final LoginFormService loginFormService;
    public final ActivityRepository activityRepository;

    @Autowired
    public AccountController(LoginFormService loginFormService, ActivityRepository activityRepository) {
        this.loginFormService = loginFormService;
        this.activityRepository = activityRepository;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return ResponseEntity.ok(loginFormService.getByLogin(authentication.getName()).getUser());
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return loginFormService.getByLogin(authentication.getName()).getUser().getOrders();
        }

        return orders;
    }

    @GetMapping(value = "/activities", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return loginFormService.getByLogin(authentication.getName()).getUser().getActivities();
        }

        return activities;
    }

    @GetMapping(value = "/activities/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Activity> getCurrentActivities() {
        List<Activity> activities = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return loginFormService.getByLogin(authentication.getName()).getUser().getActivities()
                    .stream()
                    .filter(a -> a.getStatus().getIdactivitystatus().equals(ActivityStatusEnum.CURRENT.getId()))
                    .collect(Collectors.toList());
        }

        return activities;
    }
}
