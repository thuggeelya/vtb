package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.Activity;
import com.example.thuggeelya.data.Order;
import com.example.thuggeelya.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    public UserRepository userRepository;

//    @GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    List<Order> getOrders(@RequestAttribute String email) {
//        List<Order> orders = new ArrayList<>();
//        userRepository.findByEmail(email).forEach(u -> orders.addAll(u.getOrders()));
//        return orders;
//    }

    @GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Activity> getActivities(@RequestAttribute String email) {
        List<Activity> activities = new ArrayList<>();
        userRepository.findByEmail(email).forEach(u -> activities.addAll(u.getActivities()));
        return activities;
    }
}
