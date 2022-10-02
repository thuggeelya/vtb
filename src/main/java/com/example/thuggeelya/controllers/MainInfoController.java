package com.example.thuggeelya.controllers;

import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MainInfoController {

    private final RestService service;

    @Autowired
    public MainInfoController(RestService service) {
        this.service = service;
    }

    @GetMapping("/activities")
    public ResponseEntity<?>
    getAllActivitiesPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(service.getPageOfActivities(offset, limit).getContent());
    }

    @GetMapping("/activities/further")
    public ResponseEntity<?>
    getFurtherActivitiesPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(service.getPageOfFurtherActivities(offset, limit).getContent());
    }
}
