package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.Goody;
import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final RestService service;

    @Autowired
    public ShopController(RestService service) {
        this.service = service;
    }

    @GetMapping("/goodies")
    public @ResponseBody List<Goody> getGoodies() {
        return service.getGoodies();
    }
}
