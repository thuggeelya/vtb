package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.Activity;
import com.example.thuggeelya.data.Order;
import com.example.thuggeelya.data.security.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    public LoginFormService loginFormService;

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
}
