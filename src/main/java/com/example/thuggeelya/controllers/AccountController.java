package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {

    public final LoginFormService loginFormService;
    public final ActivityRepository activityRepository;
    public final UserRepository userRepository;

    @Autowired
    public AccountController(LoginFormService loginFormService, ActivityRepository activityRepository, UserRepository userRepository) {
        this.loginFormService = loginFormService;
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}/nfts")
    public ResponseEntity<?> getUserNfts(@PathVariable Integer id) {
        return ResponseEntity.ok(userRepository.findByIduser(id)
                .orElseThrow(NoSuchElementException::new)
                .getIdwalet()
                .getNfts());
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return new ArrayList<>(userRepository.findByIduser(loginFormService
                    .getByLogin(authentication.getName())
                    .getIduser()).get().getOrders());
        }

        return orders;
    }

    @GetMapping(value = "/activities", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return new ArrayList<>(userRepository.findByIduser(loginFormService
                    .getByLogin(authentication.getName())
                    .getIduser()).get().getActivities());
        }

        return activities;
    }

    @GetMapping(value = "/activities/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Activity> getCurrentActivities() {
        List<Activity> activities = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userRepository.findByIduser(loginFormService
                    .getByLogin(authentication.getName())
                    .getIduser()).get()
                    .getActivities()
                    .stream()
                    .filter(a -> a.getStatus().getIdactivitystatus().equals(ActivityStatusEnum.CURRENT.getId()))
                    .collect(Collectors.toList());
        }

        return activities;
    }
}
